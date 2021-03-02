package com.daliu.order.myrule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2021-02-23 13:42
 * @Version:1.0
 **/
public class TheSameClusterPriorityRule extends AbstractLoadBalancerRule {
    private static final Logger log = LoggerFactory.getLogger(TheSameClusterPriorityRule.class);

    @Autowired
    private NacosDiscoveryProperties discoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        //读取配置文件并且初始化,ribbon内部的 几乎用不上
    }

    @Override
    public Server choose(Object key) {
        //第一步:获取当前服务所在的集群
        String currentClusterName = discoveryProperties.getClusterName();
        //第二步:获取一个负载均衡对象
        BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) getLoadBalancer();
        //第三步:获取当前调用的微服务的名称
        String invokedSerivceName = baseLoadBalancer.getName();
        //第四步:获取nacos clinet的服务注册发现组件的api
        NamingService namingService = discoveryProperties.namingServiceInstance();
        //第五步:获取所有的服务实例
        List<Instance> allInstance = new ArrayList<>();
        try {
            allInstance = namingService.getAllInstances(invokedSerivceName);
        } catch (NacosException e) {
            e.printStackTrace();
        }

        List<Instance> theSameClusterNameInstList = new ArrayList<>();
        //第六步:过滤筛选同集群下的所有实例
        for (Instance instance : allInstance) {
            if (StringUtils.endsWithIgnoreCase(instance.getClusterName(), currentClusterName)) {
                theSameClusterNameInstList.add(instance);
            }
        }

        Instance toBeChooseInstance;
        //第七步:选择合适的一个实例调用
        if (theSameClusterNameInstList.isEmpty()) {
            toBeChooseInstance = WeightBalancerRule.chooseInstanceByRandomWeight(allInstance);
        }
        //log.info("发生跨集群调用‐‐‐>当前微服务所在集群:{},被调用微服务所在集群:{},Host:{},Port:{}",
        return null;
    }
}