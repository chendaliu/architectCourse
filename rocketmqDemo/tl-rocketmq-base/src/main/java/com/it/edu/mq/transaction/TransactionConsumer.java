package com.it.edu.mq.transaction;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author ：
 * @date：2019/9/24
 * @version: V1.0
 * @slogan:
 * @description :
 */
public class TransactionConsumer {
    public static void main(String[] args) throws InterruptedException, MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("transaction_group");

        // ;192.168.241.199:9876
        consumer.setNamesrvAddr("118.25.53.252:9876");

        consumer.subscribe("TopicTransaction", "*");

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                System.out.println("开始提交消费端本地事务.....");
                System.out.println(new String(msg.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
