package com.universe.spring.controller;

import com.starter.entity.StudentDemo;
import com.starter.service.Service;
import com.universe.spring.annocation.EchoAnno;
import com.universe.spring.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 * @author lx
 */
@RestController
public class LoginController {

    @Autowired
    Service service;

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

    @RequestMapping("/log/starter")
    public String myStarter(){
        StudentDemo demo = new StudentDemo();
        demo.setName("阿笨笨");
        demo.setId(1);
        service.setStudent(demo);
        service.echoMessage();
        return "gogogogogo";
    }
}
