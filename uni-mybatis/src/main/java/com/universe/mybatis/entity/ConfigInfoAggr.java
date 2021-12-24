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
 * 增加租户字段
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@TableName("config_info_aggr")
@ApiModel(value = "ConfigInfoAggr对象", description = "增加租户字段")
public class ConfigInfoAggr implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("data_id")
    private String dataId;

    @ApiModelProperty("group_id")
    private String groupId;

    @ApiModelProperty("datum_id")
    private String datumId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("修改时间")
    private LocalDateTime gmtModified;

    private String appName;

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

    public String getDatumId() {
        return datumId;
    }

    public void setDatumId(String datumId) {
        this.datumId = datumId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
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

    @Override
    public String toString() {
        return "ConfigInfoAggr{" +
        "id=" + id +
        ", dataId=" + dataId +
        ", groupId=" + groupId +
        ", datumId=" + datumId +
        ", content=" + content +
        ", gmtModified=" + gmtModified +
        ", appName=" + appName +
        ", tenantId=" + tenantId +
        "}";
    }
}
