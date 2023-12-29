package com.pxzq.maoqiumanager.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/24 09:10:48
 */

@Configuration
@MapperScan("com.pxzq.maoqiumanager.dao")
public class MybatisPlusConfig {
}