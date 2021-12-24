package com.universe.mybatis.service.impl;

import com.universe.mybatis.entity.ConfigInfo;
import com.universe.mybatis.mapper.ConfigInfoMapper;
import com.universe.mybatis.service.IConfigInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * config_info 服务实现类
 * </p>
 *
 * @author dianxiaoer
 * @since 2021-12-22
 */
@Service
public class ConfigInfoServiceImpl extends ServiceImpl<ConfigInfoMapper, ConfigInfo> implements IConfigInfoService {

}
