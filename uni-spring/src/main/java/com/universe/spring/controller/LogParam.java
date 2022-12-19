package com.universe.spring.controller;

import com.sun.istack.internal.NotNull;
import lombok.Data;

/**
 * 参数测试
 * @author
 */
@Data
public class LogParam {

    @NotNull
    private Integer code;

    private String msg;

}
