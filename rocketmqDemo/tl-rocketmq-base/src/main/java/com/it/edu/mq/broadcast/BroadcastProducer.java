package com.it.edu.mq.broadcast;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author ：
 * @date：2019/9/29
 * @version: V1.0
 * @slogan:
 * @description :
 */
public class BroadcastProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("producer_model_group");
        producer.setNamesrvAddr("118.25.53.252:9876;192.168.241.199:9876");
        producer.start();

        for (int i = 0; i < 4; i++){
            Message msg = new Message("TopicTest",
                    "TagA",
                    "OrderID188",
                    ("Hello world"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();
    }

}
