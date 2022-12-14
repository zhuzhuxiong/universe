package com.universe.mybatis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.universe.mybatis.entity.User;
import com.universe.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dianxiaoer
 * @since 2022-12-14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping("/one/{id}")
    public User getOne(@PathVariable Integer id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return userService.getOne(wrapper);
    }

}

