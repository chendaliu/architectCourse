package com.daliu.activiti.conf;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author: daliu
 * @CreateTime: 2021-06-29 20:25
 * @Version:1.0
 **/
@Component
public class ActivitiConfig implements ProcessEngineConfigurationConfigurer {

    @Override
    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
        processEngineConfiguration.setActivityFontName("宋体");
        processEngineConfiguration.setLabelFontName("宋体");
        processEngineConfiguration.setAnnotationFontName("宋体");

        processEngineConfiguration.setDbIdentityUsed(false);
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
    }

}