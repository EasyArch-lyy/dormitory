package com.data.dormitory.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.data.dormitory.mbg.mapper")
public class MyBatisConfig {
}


