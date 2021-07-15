package com.daliu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Title:
 * @Description:
 * @Author: daliu
 * @CreateTime: 2021-07-14 20:20
 * @Version:1.0
 **/
@SpringBootTest
public class InitTableTest {
    @Test
    public void initTables() {
        // 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.32.128:3307/activiti?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 创建流程引擎的配置
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://192.168.32.128:3307/activiti?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("123456");
//		configuration.setDataSource(dataSource);
        /**
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE 如果数据库里面没有activit的表，也不会创建
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP 创建表，使用完之后删除
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE 如果数据库里面没有表，就创建
         *
         * dorp-create 代表如果数据库里面有表，那么先删除再创建
         *
         */
        // 配置表的初始化的方式
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);

        // 得到流程引擎
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void initTables2() {
        // 创建数据源

        // 创建流程引擎的配置
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://192.168.32.128:3307/activiti?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("123456");
        /**
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE 如果数据库里面没有activit的表，也不会创建
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP 创建表，使用完之后删除
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE 如果数据库里面没有表，就创建
         *
         * dorp-create 代表如果数据库里面有表，那么先删除再创建
         *
         */
        // 配置表的初始化的方式
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);

        // 得到流程引擎
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }
}