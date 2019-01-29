package com.johnxb.bbs.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource(value = "classpath:com/johnxb/bbs/dao/application.properties")
@MapperScan("com.johnxb.bbs.dao.mapper")
public class BbsDaoConfiguration {
}