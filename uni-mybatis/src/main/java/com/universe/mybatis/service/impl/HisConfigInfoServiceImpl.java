package com.universe.mybatis.service.impl;

import com.universe.mybatis.entity.HisConfigInfo;
import com.universe.mybatis.mapper.HisConfigInfoMapper;
import com.universe.mybatis.service.IHisConfigInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 多租户改造 服务实现类
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@Service
public class HisConfigInfoServiceImpl extends ServiceImpl<HisConfigInfoMapper, HisConfigInfo> implements IHisConfigInfoService {

}
