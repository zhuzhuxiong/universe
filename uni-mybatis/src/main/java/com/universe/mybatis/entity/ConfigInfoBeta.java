package com.universe.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * config_info_beta
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@TableName("config_info_beta")
@ApiModel(value = "ConfigInfoBeta对象", description = "config_info_beta")
public class ConfigInfoBeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("data_id")
    private String dataId;

    @ApiModelProperty("group_id")
    private String groupId;

    @ApiModelProperty("app_name")
    private String appName;

    @ApiModelProperty("content")
    private String content;

    @ApiModelProperty("betaIps")
    private String betaIps;

    @ApiModelProperty("md5")
    private String md5;

    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty("source user")
    private String srcUser;

    @ApiModelProperty("source ip")
    private String srcIp;

    @ApiModelProperty("租户字段")
    private String tenantId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBetaIps() {
        return betaIps;
    }

    public void setBetaIps(String betaIps) {
        this.betaIps = betaIps;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getSrcUser() {
        return srcUser;
    }

    public void setSrcUser(String srcUser) {
        this.srcUser = srcUser;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "ConfigInfoBeta{" +
        "id=" + id +
        ", dataId=" + dataId +
        ", groupId=" + groupId +
        ", appName=" + appName +
        ", content=" + content +
        ", betaIps=" + betaIps +
        ", md5=" + md5 +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", srcUser=" + srcUser +
        ", srcIp=" + srcIp +
        ", tenantId=" + tenantId +
        "}";
    }
}
