package com.universe.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("single_table")
@ApiModel(value = "SingleTable对象", description = "")
public class SingleTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String key1;

    private Integer key2;

    private String key3;

    private String keyPart1;

    private String keyPart2;

    private String keyPart3;

    private String commonField;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public Integer getKey2() {
        return key2;
    }

    public void setKey2(Integer key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getKeyPart1() {
        return keyPart1;
    }

    public void setKeyPart1(String keyPart1) {
        this.keyPart1 = keyPart1;
    }

    public String getKeyPart2() {
        return keyPart2;
    }

    public void setKeyPart2(String keyPart2) {
        this.keyPart2 = keyPart2;
    }

    public String getKeyPart3() {
        return keyPart3;
    }

    public void setKeyPart3(String keyPart3) {
        this.keyPart3 = keyPart3;
    }

    public String getCommonField() {
        return commonField;
    }

    public void setCommonField(String commonField) {
        this.commonField = commonField;
    }

    @Override
    public String toString() {
        return "SingleTable{" +
        "id=" + id +
        ", key1=" + key1 +
        ", key2=" + key2 +
        ", key3=" + key3 +
        ", keyPart1=" + keyPart1 +
        ", keyPart2=" + keyPart2 +
        ", keyPart3=" + keyPart3 +
        ", commonField=" + commonField +
        "}";
    }
}
