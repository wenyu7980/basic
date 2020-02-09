package com.wenyu7980.basic.service.organization.permission.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wenyu
 * @date 2020-02-09 
 */
@Embeddable
public class PermissionKey implements Serializable {
    /** 方法 */
    private String method;
    /** 路径 */
    private String path;

    private PermissionKey() {
    }

    public PermissionKey(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PermissionKey that = (PermissionKey) object;
        return Objects.equals(method, that.method) && Objects
                .equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path);
    }
}
