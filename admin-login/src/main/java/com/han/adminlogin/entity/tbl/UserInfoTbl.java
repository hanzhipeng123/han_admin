package com.han.adminlogin.entity.tbl;

import java.io.Serializable;
import java.util.Date;

public class UserInfoTbl implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String unionId;
    private String nickname;
    private String mobile;
    private Short registryPlatform;
    private String deviceToken;
    private String brthday;
    private String userPic;
    private Integer recProvinceId;
    private Integer recCityId;
    private Integer recDistrictId;
    private Date createTime;
    private Date bindingMobileTime;
    private Date updateTime;
    private Integer version;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUnionId() {
        return unionId;
    }
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Short getRegistryPlatform() {
        return registryPlatform;
    }
    public void setRegistryPlatform(Short registryPlatform) {
        this.registryPlatform = registryPlatform;
    }
    public String getDeviceToken() {
        return deviceToken;
    }
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
    public String getBrthday() {
        return brthday;
    }
    public void setBrthday(String brthday) {
        this.brthday = brthday;
    }
    public String getUserPic() {
        return userPic;
    }
    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
    public Integer getRecProvinceId() {
        return recProvinceId;
    }
    public void setRecProvinceId(Integer recProvinceId) {
        this.recProvinceId = recProvinceId;
    }
    public Integer getRecCityId() {
        return recCityId;
    }
    public void setRecCityId(Integer recCityId) {
        this.recCityId = recCityId;
    }
    public Integer getRecDistrictId() {
        return recDistrictId;
    }
    public void setRecDistrictId(Integer recDistrictId) {
        this.recDistrictId = recDistrictId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getBindingMobileTime() {
        return bindingMobileTime;
    }
    public void setBindingMobileTime(Date bindingMobileTime) {
        this.bindingMobileTime = bindingMobileTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

}
