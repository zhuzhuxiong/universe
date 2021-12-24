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
 * 多租户改造
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@TableName("his_config_info")
@ApiModel(value = "HisConfigInfo对象", description = "多租户改造")
public class HisConfigInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @TableId(value = "nid", type = IdType.AUTO)
    private Long nid;

    private String dataId;

    private String groupId;

    @ApiModelProperty("app_name")
    private String appName;

    private String content;

    private String md5;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String srcUser;

    private String srcIp;

    private String opType;

    @ApiModelProperty("租户字段")
    private String tenantId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
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

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "HisConfigInfo{" +
        "id=" + id +
        ", nid=" + nid +
        ", dataId=" + dataId +
        ", groupId=" + groupId +
        ", appName=" + appName +
        ", content=" + content +
        ", md5=" + md5 +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", srcUser=" + srcUser +
        ", srcIp=" + srcIp +
        ", opType=" + opType +
        ", tenantId=" + tenantId +
        "}";
    }
}
