package com.smant.common.core.enums;


/**
 * 通用状态
 */
public enum CommStatus {
    INITIALIZE(1, "初始化", "初始化:类似草稿状态，启用前的准备状态"),
    ENABLE(2, "启用/有效", "启用/有效"),
    DISABLE(3, "禁用/失效", "禁用/失效"),
    DELETE(99, "删除", "删除：逻辑删除，永远失效."),

    ;
    private final int statusCode;
    private final String statusName;
    private final String statusDesc;

    CommStatus(int statusCode, String statusName, String statusDesc) {
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.statusDesc = statusDesc;
    }

    private static final CommStatus[] ALL_VALUES = CommStatus.values();
    public static CommStatus commStatus(int statusCode){
        for(CommStatus commStatus : ALL_VALUES){
            if(commStatus.statusCode == statusCode){
                return commStatus;
            }
        }
        return null;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getStatusDesc() {
        return statusDesc;
    }
}
