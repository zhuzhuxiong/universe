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
 * config_info
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@TableName("config_info")
@ApiModel(value = "ConfigInfo对象", description = "config_info")
public class ConfigInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("data_id")
    private String dataId;

    private String groupId;

    @ApiModelProperty("content")
    private String content;

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

    private String appName;

    @ApiModelProperty("租户字段")
    private String tenantId;

    private String cDesc;

    private String cUse;

    private String effect;

    private String type;

    private String cSchema;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public String getcUse() {
        return cUse;
    }

    public void setcUse(String cUse) {
        this.cUse = cUse;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getcSchema() {
        return cSchema;
    }

    public void setcSchema(String cSchema) {
        this.cSchema = cSchema;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
        "id=" + id +
        ", dataId=" + dataId +
        ", groupId=" + groupId +
        ", content=" + content +
        ", md5=" + md5 +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", srcUser=" + srcUser +
        ", srcIp=" + srcIp +
        ", appName=" + appName +
        ", tenantId=" + tenantId +
        ", cDesc=" + cDesc +
        ", cUse=" + cUse +
        ", effect=" + effect +
        ", type=" + type +
        ", cSchema=" + cSchema +
        "}";
    }
}
