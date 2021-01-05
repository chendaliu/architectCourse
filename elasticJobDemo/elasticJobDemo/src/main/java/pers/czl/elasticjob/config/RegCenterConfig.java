package pers.czl.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: 注册中心配置类
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-17 16:53
 * @Version:1.0
 **/
@Configuration
public class RegCenterConfig {
    /**
     * 配置zookeeper
     * @param serverList
     * @param namespace
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter zookeeperRegistryCenter(
            @Value("${zk.serverList}") final String serverList,
            @Value("${zk.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}