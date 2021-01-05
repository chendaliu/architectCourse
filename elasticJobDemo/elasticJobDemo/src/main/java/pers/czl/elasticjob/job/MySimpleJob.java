package pers.czl.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Title: 作业类
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-17 16:44
 * @Version:1.0
 **/
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        //获取分片总数
        int shardingTotalCount = shardingContext.getShardingTotalCount();
        //获取分片项
        int shardingItem = shardingContext.getShardingItem();
        //获取分片项参数
        String shardingParameter = shardingContext.getShardingParameter();

        System.out.println("分片总数：" + shardingTotalCount);
        System.out.println("分片项：" + shardingItem);
        System.out.println("分片项参数：" + shardingParameter);
        System.out.println("作业名称：" + shardingContext.getJobName());

        //不同分片项进行不同处理
        switch (shardingItem) {
            case 0:
                System.out.println("第1个分片项参数：" + shardingParameter);
                break;
            case 1:
                System.out.println("第2个分片项参数：" + shardingParameter);
                break;
            case 2:
                System.out.println("第3个分片项参数：" + shardingParameter);
                break;
            case 3:
                System.out.println("第4个分片项参数：" + shardingParameter);
                break;
        }

    }
}