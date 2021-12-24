package com.universe.mybatis.service.impl;

import com.universe.mybatis.entity.Users;
import com.universe.mybatis.mapper.UsersMapper;
import com.universe.mybatis.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
