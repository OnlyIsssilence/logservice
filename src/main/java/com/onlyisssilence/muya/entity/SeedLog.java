package com.onlyisssilence.muya.entity;

import java.io.Serializable;

/**
 * Author: MuYa
 * Date  : 2017/1/11
 * Description:
 */
public class SeedLog implements Serializable {

    //日志ID
    private String id;

    //城市ID
    private String cityCode;

    // 版本号
    private String version;

    // 用户ID
    private String uid;

    // 埋点内容
    private String seedId;

    // 日志埋点时间
    private String seedTime;

    // 日志创建时间
    private String createTime;

    // 操作系统版本
    private String osVersion;

    // 手机类型
    private String phoneModel;

    @Override
    public String toString() {
        return "SeedLog{" +
                "id='" + id + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", version='" + version + '\'' +
                ", uid='" + uid + '\'' +
                ", seedId='" + seedId + '\'' +
                ", seedTime='" + seedTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", phoneModel='" + phoneModel + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSeedId() {
        return seedId;
    }

    public void setSeedId(String seedId) {
        this.seedId = seedId;
    }

    public String getSeedTime() {
        return seedTime;
    }

    public void setSeedTime(String seedTime) {
        this.seedTime = seedTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }
}
