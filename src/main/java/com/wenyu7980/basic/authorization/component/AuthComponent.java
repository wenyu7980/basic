package com.wenyu7980.basic.authorization.component;

import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.permission.service.PermissionService;
import com.wenyu7980.basic.exception.code500.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Component
public class AuthComponent {
    /** 路径匹配规则 */
    private static final AntPathMatcher MATCHER = new AntPathMatcher();
    @Autowired
    private PermissionService permissionService;

    /**
     * 检查
     * @param method
     * @param path
     * @return
     */
    public PermissionEntity getPermissionByRequest(String method, String path) {
        List<PermissionEntity> permissions = permissionService
                .findByMethod(method);
        return permissions.stream()
                .filter(permission -> MATCHER.match(permission.getPath(), path))
                .sorted((o1, o2) -> MATCHER.match(o1.getPath(), o2.getPath()) ?
                        1 :
                        -1).findFirst().orElseThrow(() -> new SystemException(
                        "开发异常:没有method:{0},path:{1}相关的权限配置", method, path));
    }

    public Set<PermissionEntity> getPermissions(String userId) {
        return permissionService.findByUserId(userId);
    }
}
