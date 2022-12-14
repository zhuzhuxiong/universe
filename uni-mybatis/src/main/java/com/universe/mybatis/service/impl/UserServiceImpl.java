package com.universe.mybatis.service.impl;

import com.universe.mybatis.entity.User;
import com.universe.mybatis.mapper.UserMapper;
import com.universe.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dianxiaoer
 * @since 2022-12-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
