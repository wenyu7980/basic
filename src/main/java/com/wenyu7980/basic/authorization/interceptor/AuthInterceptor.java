package com.wenyu7980.basic.authorization.interceptor;

import com.wenyu7980.basic.authorization.annotation.AuthRequest;
import com.wenyu7980.basic.authorization.component.AuthComponent;
import com.wenyu7980.basic.authorization.constant.TokenType;
import com.wenyu7980.basic.authorization.domain.RequestUser;
import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.authorization.service.TokenService;
import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import com.wenyu7980.basic.exception.code401.NoLoginException;
import com.wenyu7980.basic.exception.code401.TokenInvalidException;
import com.wenyu7980.basic.exception.code403.InsufficientException;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    /** 是否是严格模式 */
    @Value("${application.login.strict:true}")
    private boolean strictMode;
    @Autowired
    private AuthComponent authComponent;
    @Autowired
    private TokenService tokenService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {
            TokenInvalidException.class
    }, rollbackFor = RuntimeException.class)
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        // 获取方法
        Method method = ((HandlerMethod) handler).getMethod();
        AuthRequest authRequest = method.getAnnotation(AuthRequest.class);
        if (Objects.nonNull(authRequest) && !authRequest.required()) {
            // 接口不需要登录
            return true;
        }
        // 请求中用户信息
        Optional<RequestInfo> optional = this
                .getRequestUserFromRequest(request);
        if (!optional.isPresent()) {
            throw new NoLoginException("请求未携带token");
        }
        RequestInfo requestInfo = optional.get();
        TokenEntity tokenEntity = this.tokenService
                .findOptionalById(requestInfo.token)
                .orElseThrow(() -> new TokenInvalidException("token已失效"));
        if (strictMode) {
            // 严格模式下校验token类型
            if (Objects.nonNull(authRequest)) {
                if (!Objects.equals(authRequest.type(), requestInfo.type)) {
                    throw new TokenInvalidException("token类型不正确");
                }
                if (!Objects
                        .equals(authRequest.type(), tokenEntity.getType())) {
                    throw new TokenInvalidException("token类型不正确");
                }
            } else {
                if (!Objects.equals(TokenType.HEADER, requestInfo.type)) {
                    throw new TokenInvalidException("token类型不正确");
                }
                if (!Objects.equals(TokenType.HEADER, tokenEntity.getType())) {
                    throw new TokenInvalidException("token类型不正确");
                }
            }
        }
        if (!tokenEntity.checkAndUpdateValid()) {
            this.tokenService.save(tokenEntity);
            throw new TokenInvalidException("token已失效");
        }
        PermissionEntity permission = authComponent
                .getPermissionByRequest(request.getMethod(),
                        request.getServletPath());
        if (!authComponent.getPermissions(tokenEntity.getUserId())
                .contains(permission)) {
            throw new InsufficientException("权限不足，没有访问{0}的权限",
                    permission.getPath());
        }
        AuthorizationUtil.set(new RequestUser(tokenEntity.getUserId(),
                tokenEntity.getDepartmentId(), tokenEntity.getCompanyId(),
                tokenEntity.getUsername(), tokenEntity.getToken(),
                tokenEntity.getType()));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        AuthorizationUtil.remove();
    }

    /**
     * 从request中获取token和username
     * @param request
     * @return
     */
    private Optional<RequestInfo> getRequestUserFromRequest(
            HttpServletRequest request) {
        // 查询参数token
        if (!StringUtils.isEmpty(request.getParameter("token"))) {
            return Optional.of(new RequestInfo(request.getParameter("token"),
                    request.getParameter("username"), TokenType.QUERY));
        }
        // header token
        if (!StringUtils.isEmpty(request.getHeader("token"))) {
            return Optional.of(new RequestInfo(request.getHeader("token"),
                    request.getHeader("username"), TokenType.HEADER));
        }
        return Optional.empty();
    }

    protected static class RequestInfo {
        /** token */
        private String token;
        /** 用户名 */
        private String username;
        /** token 类型 */
        private TokenType type;

        public RequestInfo(String token, String username, TokenType type) {
            this.token = token;
            this.username = username;
            this.type = type;
        }
    }
}
