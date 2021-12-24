package com.universe.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * config_tag_relation
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@TableName("config_tags_relation")
@ApiModel(value = "ConfigTagsRelation对象", description = "config_tag_relation")
public class ConfigTagsRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("tag_name")
    private String tagName;

    @ApiModelProperty("tag_type")
    private String tagType;

    @ApiModelProperty("data_id")
    private String dataId;

    @ApiModelProperty("group_id")
    private String groupId;

    @ApiModelProperty("tenant_id")
    private String tenantId;

    @TableId(value = "nid", type = IdType.AUTO)
    private Long nid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    @Override
    public String toString() {
        return "ConfigTagsRelation{" +
        "id=" + id +
        ", tagName=" + tagName +
        ", tagType=" + tagType +
        ", dataId=" + dataId +
        ", groupId=" + groupId +
        ", tenantId=" + tenantId +
        ", nid=" + nid +
        "}";
    }
}
