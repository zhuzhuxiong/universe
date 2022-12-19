package com.universe.spring.controller;

import com.sun.istack.internal.NotNull;
import com.universe.spring.exception.BizException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 * @author lx
 */
@RestController
public class LoginController {

    /**
     * 全局业务异常处理测试
     * @param param
     * @return
     */
    @RequestMapping("/log/test")
    public String echoString(LogParam param){
        if (0 == param.getCode()){
            throw new BizException(1,"测试异常");
        }else if (1 == param.getCode()) {
            int i = 1 / 0;
            return String.valueOf(i);
        }else {
            return "gogo";
        }
    }
}
