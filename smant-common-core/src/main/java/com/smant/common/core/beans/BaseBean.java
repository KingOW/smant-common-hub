package com.smant.common.core.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 基本bean
 */
@Data
public class BaseBean implements Serializable {

    /**
     * 系统编码/系统名称
     */
    private String systemCode;
    private String systemName;
    /**
     * 版本号
     */
    private int version;

    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人/创建时间
     */
    private Date createDt;
    private String createBy;

    /**
     * 更新人/更新时间
     */
    private Date updateDt;
    private String updateBy;


}
