package com.wenyu7980.basic.common.auditing.domain;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 *
 * @author wenyu
 * @date 2020-02-01 
 */
public class AuditingDomain {
    @ApiModelProperty(value = "创建者", readOnly = true)
    private String createdUserId;
    @ApiModelProperty(value = "创建时间", readOnly = true)
    private LocalDateTime createdDateTime;
    @ApiModelProperty(value = "更新者", readOnly = true)
    private String updatedUserId;
    @ApiModelProperty(value = "更新者", readOnly = true)
    private LocalDateTime updatedDateTime;
    @ApiModelProperty(value = "删除标志", readOnly = true)
    private Boolean deletedFlag;
    @ApiModelProperty(value = "删除者", readOnly = true)
    private String deletedUserId;
    @ApiModelProperty(name = "删除时间", readOnly = true)
    private LocalDateTime deletedDateTime;

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public String getDeletedUserId() {
        return deletedUserId;
    }

    public void setDeletedUserId(String deletedUserId) {
        this.deletedUserId = deletedUserId;
    }

    public LocalDateTime getDeletedDateTime() {
        return deletedDateTime;
    }

    public void setDeletedDateTime(LocalDateTime deletedDateTime) {
        this.deletedDateTime = deletedDateTime;
    }
}
