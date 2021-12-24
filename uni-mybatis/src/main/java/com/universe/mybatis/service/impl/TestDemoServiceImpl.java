package com.universe.mybatis.service.impl;

import com.universe.mybatis.entity.TestDemo;
import com.universe.mybatis.mapper.TestDemoMapper;
import com.universe.mybatis.service.ITestDemoService;
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
public class TestDemoServiceImpl extends ServiceImpl<TestDemoMapper, TestDemo> implements ITestDemoService {

}
