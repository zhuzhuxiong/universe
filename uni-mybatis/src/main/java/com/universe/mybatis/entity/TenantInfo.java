package com.universe.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * tenant_info
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@TableName("tenant_info")
@ApiModel(value = "TenantInfo对象", description = "tenant_info")
public class TenantInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("kp")
    private String kp;

    @ApiModelProperty("tenant_id")
    private String tenantId;

    @ApiModelProperty("tenant_name")
    private String tenantName;

    @ApiModelProperty("tenant_desc")
    private String tenantDesc;

    @ApiModelProperty("create_source")
    private String createSource;

    @ApiModelProperty("创建时间")
    private Long gmtCreate;

    @ApiModelProperty("修改时间")
    private Long gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantDesc() {
        return tenantDesc;
    }

    public void setTenantDesc(String tenantDesc) {
        this.tenantDesc = tenantDesc;
    }

    public String getCreateSource() {
        return createSource;
    }

    public void setCreateSource(String createSource) {
        this.createSource = createSource;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "TenantInfo{" +
        "id=" + id +
        ", kp=" + kp +
        ", tenantId=" + tenantId +
        ", tenantName=" + tenantName +
        ", tenantDesc=" + tenantDesc +
        ", createSource=" + createSource +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
