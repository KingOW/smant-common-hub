package com.smant.common.core.enums;

import com.smant.common.core.beans.Address;
import com.smant.common.core.utils.StringExtUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AddressType {
    GENERAL_ADDRESS("GA", "普通地址", "普通地址"),
    HOME_ADDRESS("HA", "家庭地址", "家庭地址"),
    DELIVERY_ADDRESS("DD", "收货地址", "收货地址"),

    ;
    private final String code;
    private final String name;
    private final String desc;

    private static final AddressType[] ALL_VALUES = AddressType.values();

    public static final AddressType AddressTypeByCode(String code) {
        if (StringExtUtils.isTrimEmpty(code)) {
            return null;
        }
        for (AddressType addressType : ALL_VALUES) {
            if (addressType.getCode().equals(code)) {
                return addressType;
            }
        }
        return null;
    }

}