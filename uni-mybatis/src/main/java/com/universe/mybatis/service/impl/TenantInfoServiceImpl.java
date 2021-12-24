package com.universe.mybatis.service.impl;

import com.universe.mybatis.entity.TenantInfo;
import com.universe.mybatis.mapper.TenantInfoMapper;
import com.universe.mybatis.service.ITenantInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * tenant_info 服务实现类
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@Service
public class TenantInfoServiceImpl extends ServiceImpl<TenantInfoMapper, TenantInfo> implements ITenantInfoService {

}
