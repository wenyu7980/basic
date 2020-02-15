package com.wenyu7980.basic.config.log;

import com.wenyu7980.basic.authorization.domain.RequestUser;
import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 失败请求日志
 * @author wenyu
 * @date 2020-01-29 
 */
@WebFilter(value = "/*", filterName = "BadRequestFilter")
public class BadRequestFilter extends HttpFilter {
    private static final int OK = 399;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(BadRequestFilter.class);

    @Override
    protected void doFilter(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (determine(request)) {
            // 可重复读数据
            BodyRepeatRequestWrapper requestWrapper = new BodyRepeatRequestWrapper(
                    request);
            // 分支输出流
            try (ByteArrayOutputStream duplicate = new ByteArrayOutputStream()) {
                BodyDuplicateResponseWrapper responseWrapper = new BodyDuplicateResponseWrapper(
                        response, duplicate);
                chain.doFilter(requestWrapper, responseWrapper);
                if (response.getStatus() > OK) {
                    this.logRequestUser();
                    this.logRequest(requestWrapper);
                    this.logResponse(response.getStatus(), duplicate);
                }
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    /**
     * 判断是否需要wrapper输出
     * 切记还未对inpustream进行wrapper，不能使用inputstream
     * @return
     */
    private boolean determine(HttpServletRequest request) {
        return true;
    }

    /**
     * 日志输出请求用户信息
     */
    private void logRequestUser() {
        if (AuthorizationUtil.isPresent()) {
            RequestUser requestUser = AuthorizationUtil.get();
            LOGGER.warn("用户ID:{}，用户名:{},token:{},部门id:{},公司id:{}",
                    requestUser.getUserId(), requestUser.getUsername(),
                    requestUser.getToken(), requestUser.getDepartmentId(),
                    requestUser.getCompanyId());
        }
    }

    /**
     * 日志输出请求数据
     */
    private void logRequest(HttpServletRequest request) throws IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        LOGGER.warn("方法:{},路径:{},查询参数:{},请求BODY:{}", request.getMethod(),
                request.getServletPath(), parameters.entrySet().stream()
                        .map((entry) -> entry.getKey() + ":" + String
                                .join(",", entry.getValue()))
                        .collect(Collectors.joining(",")),
                IOUtils.toString(request.getInputStream(),
                        Charset.defaultCharset()).replaceAll("\\r|\\n", ""));
    }

    /**
     * 日志输出响应数据信息
     * @param status
     * @param outputStream
     */
    private void logResponse(int status, OutputStream outputStream) {
        LOGGER.warn("响应status:{},BODY:{}", status, outputStream);
    }
}
