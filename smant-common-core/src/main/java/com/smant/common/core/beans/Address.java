package com.smant.common.core.beans;

import com.smant.common.core.enums.AddressType;
import com.smant.common.core.utils.StringExtUtils;

import java.io.Serializable;

/**
 * 位置对象
 */
public class Address implements Serializable {

    /**
     * 国家
     */
    private String countryCode;
    private String countryName;
    /**
     * 省
     */
    private String provinceCode;
    private String provinceName;
    /**
     * 市
     */
    private String cityCode;
    private String cityName;
    /**
     * 区
     */
    private String areaCode;
    private String areaName;

    /**
     * 乡镇
     */
    private String townCode;
    private String townName;

    /**
     * 乡村
     */
    private String villageCode;
    private String villageName;

    /**
     * 街道
     */
    private String streetCode;
    private String streetName;
    /**
     * 详细位置
     */
    private String address;

    /**
     * 全路径
     */
    private String fullAddress;

    /**
     * 地址类型
     */
    private String addressTypeCode = AddressType.GENERAL_ADDRESS.getCode();
    private String addressTypeName = AddressType.GENERAL_ADDRESS.getName();
    /**
     * 地址标签
     */
    //private List<String> addressTags = Lists.newArrayList();
    private String addressTag;

    public Address AddressTag(String addressTag) {
        this.addressTag = addressTag;
        return this;
    }
//    public Address AddTag(String tag) {
//        if(!StringExtUtils.isEmpty(tag)){
//            addressTags.add(tag);
//        }
//        return this;
//    }

    public Address AddressType(AddressType addressType) {
        if (addressType != null) {
            this.addressTypeCode = addressType.getCode();
            this.addressTypeName = addressType.getName();
        }
        return this;
    }

    public Address Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        return this;
    }

    public Address Province(String provinceCode, String provinceName) {
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        return this;
    }

    public Address City(String cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        return this;
    }

    public Address Area(String areaCode, String areaName) {
        this.areaCode = areaCode;
        this.areaName = areaName;
        return this;
    }

    public Address Town(String townCode, String townName) {
        this.townCode = townCode;
        this.townName = townName;
        return this;
    }

    public Address Village(String villageCode, String villageName) {
        this.villageCode = villageCode;
        this.villageName = villageName;
        return this;
    }

    public Address Street(String streetCode, String streetName) {
        this.streetCode = streetCode;
        this.streetName = streetName;
        return this;
    }

    public Address DetailAddress(String address) {
        this.address = address;
        return this;
    }

    public Address FullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }

    public Address FullAddress() {
        StringBuilder strBuilder = new StringBuilder();
        if (StringExtUtils.isTrimEmpty(this.countryName)) {
            strBuilder.append("中国,");
        } else {
            strBuilder.append(this.countryName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.provinceName)) {
            strBuilder.append(this.provinceName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.cityName)) {
            strBuilder.append(this.cityName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.areaName)) {
            strBuilder.append(this.areaName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.townName)) {
            strBuilder.append(this.townName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.villageName)) {
            strBuilder.append(this.villageName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.streetName)) {
            strBuilder.append(this.streetName + ",");
        }
        if (!StringExtUtils.isTrimEmpty(this.address)) {
            strBuilder.append(this.address + ";");
        }
        this.address = strBuilder.toString();
        return this;
    }

    public String getAddressTag() {
        return addressTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
