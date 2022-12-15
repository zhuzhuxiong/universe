package com.universe.mybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author lx
 */
@Configuration
public class DataSourceConfig {

    @Bean("user1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource userDataSource(){
        return DataSourceBuilder.create().build();
    }
}
