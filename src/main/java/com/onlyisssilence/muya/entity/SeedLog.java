package com.onlyisssilence.muya.entity;

import java.io.Serializable;

/**
 * Author: MuYa
 * Date  : 2017/1/11
 * Description:
 */
public class SeedLog implements Serializable {

    //日志ID
    private String logId;

    //城市ID
    private String cityCode;

    // 版本号
    private String version;

    // 用户ID
    private String uid;

    // 日志埋点时间
    private String seedTime;

    // 日志创建时间
    private String createTime;

    @Override
    public String toString() {
        return "SeedLog{" +
                "logId='" + logId + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", version='" + version + '\'' +
                ", uid='" + uid + '\'' +
                ", seedTime=" + seedTime +
                ", createTime=" + createTime +
                '}';
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
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

    public String getSeedTime() {
        return seedTime;
    }

    public void setSeedTime(String seedTime) {
        this.seedTime = seedTime;
    }


}
