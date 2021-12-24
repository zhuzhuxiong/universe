package com.universe.mybatis.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@ApiModel(value = "Permissions对象", description = "")
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String role;

    private String resource;

    private String action;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Permissions{" +
        "role=" + role +
        ", resource=" + resource +
        ", action=" + action +
        "}";
    }
}
