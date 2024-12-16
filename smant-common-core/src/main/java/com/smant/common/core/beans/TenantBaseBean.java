package com.smant.common.core.beans;


/**
 * 租户 基础Bean
 */
public class TenantBaseBean extends BaseBean{

    /**
     * 租户id/租户编码/租户名称
     */
    private String tenantId;
    private String tenantCode;
    private String tenantName;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
