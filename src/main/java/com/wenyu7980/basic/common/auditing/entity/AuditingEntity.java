package com.wenyu7980.basic.common.auditing.entity;

import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 审计entity
 * @author wenyu
 * @date 2020-02-01 
 */
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class AuditingEntity {

    @CreatedBy
    private String createdUserId;
    @CreatedDate
    private LocalDateTime createdDateTime;
    @LastModifiedBy
    private String updatedUserId;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;
    /** 删除标志 */
    private Boolean deletedFlag = false;
    private String deletedUserId;
    private LocalDateTime deletedDateTime;

    /**
     * 设置删除
     * @param deletedFlag
     */
    public void setDeletedFlag(boolean deletedFlag) {
        if (deletedFlag == this.deletedFlag) {
            // 要设置的状态和已设置的状态一致时，不修改
            return;
        }
        if (deletedFlag) {
            this.deletedFlag = deletedFlag;
            this.deletedDateTime = LocalDateTime.now();
            this.deletedUserId = AuthorizationUtil.getUserId();
        } else {
            this.deletedFlag = false;
            this.deletedDateTime = null;
            this.deletedUserId = null;
        }
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    public String getDeletedUserId() {
        return deletedUserId;
    }

    public LocalDateTime getDeletedDateTime() {
        return deletedDateTime;
    }
}
