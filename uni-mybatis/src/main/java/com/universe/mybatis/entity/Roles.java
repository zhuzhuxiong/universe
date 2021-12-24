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
@ApiModel(value = "Roles对象", description = "")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String role;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +
        "username=" + username +
        ", role=" + role +
        "}";
    }
}
