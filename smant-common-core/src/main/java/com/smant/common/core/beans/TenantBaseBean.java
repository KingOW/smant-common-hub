package com.smant.common.core.beans;

import lombok.Data;

/**
 * 租户 基础Bean
 */
@Data
public class TenantBaseBean extends BaseBean{

    /**
     * 租户id/租户编码/租户名称
     */
    private String tenantId;
    private String tenantCode;
    private String tenantName;
}
