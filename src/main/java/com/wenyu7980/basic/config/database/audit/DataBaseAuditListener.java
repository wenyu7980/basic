package com.wenyu7980.basic.config.database.audit;

import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import com.wenyu7980.basic.config.database.audit.annotation.DeleteFlag;
import com.wenyu7980.basic.config.database.audit.annotation.DeletedBy;
import com.wenyu7980.basic.config.database.audit.annotation.DeletedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 *
 * @author wenyu
 * @date 2020-01-30 
 */
public class DataBaseAuditListener {
    @PrePersist
    public void prePersist(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (checkAnnotation(field, CreatedDate.class) || checkAnnotation(
                    field, LastModifiedDate.class)) {
                setDate(object, field);
            } else if (checkAnnotation(field, CreatedBy.class)
                    || checkAnnotation(field, LastModifiedBy.class)) {
                setUserId(object, field);
            }
        }
    }

    @PreUpdate
    public void preUpdate(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        boolean delFlag = false;
        Field deletedByField = null;
        Field deletedDateField = null;
        for (Field field : fields) {
            if (checkAnnotation(field, LastModifiedDate.class)) {
                setDate(object, field);
            } else if (checkAnnotation(field, LastModifiedBy.class)) {
                setUserId(object, field);
            } else if (checkAnnotation(field, DeleteFlag.class)) {
                field.setAccessible(true);
                delFlag = (boolean) field.get(object);
            } else if (checkAnnotation(field, DeletedBy.class)) {
                deletedByField = field;
            } else if (checkAnnotation(field, DeletedDate.class)) {
                deletedDateField = field;
            }
        }
        if (delFlag) {
            setUserId(object, deletedByField);
            setDate(object, deletedDateField);
        }

    }

    private boolean checkAnnotation(Field field, Class clazz) {
        return field.getAnnotation(clazz) == null;
    }

    private void setDate(Object obj, Field field)
            throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, LocalDateTime.now());
    }

    private void setUserId(Object obj, Field field)
            throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, AuthorizationUtil.getUserId());
    }
}
