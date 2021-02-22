package pers.czl.elasticjob.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobRootConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.czl.elasticjob.job.MySimpleJob;

/**
 * @Title: 作业配置类
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-17 17:18
 * @Version:1.0
 **/
@Configuration
public class MySimpleJobConfig {

    @Autowired
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    @Bean
    public SimpleJob stockJob() {
        return new MySimpleJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleJob simpleJob) {
        return new SpringJobScheduler(simpleJob, zookeeperRegistryCenter, createSimpleJobConfiguration());
    }

    private static LiteJobConfiguration createSimpleJobConfiguration() {
        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("SimpleJobDemo", "0/5 * * * * ?", 4)
                .shardingItemParameters("0=北京,1=上海,2=广州,3=深圳").build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MySimpleJob.class.getCanonicalName());
        // 定义Lite作业根配置
        JobRootConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();

        return (LiteJobConfiguration) simpleJobRootConfig;

    }
}