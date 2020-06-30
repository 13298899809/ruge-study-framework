package com.ruge.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Producer
 * @date 2020.06.29 15:13
 */
@Slf4j
@Component
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送消息到kafka
     */
    public RecordMetadata sendChannelMess(String topic, Object message) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, message);
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = future.get().getRecordMetadata();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
        System.out.println("发送成功");
        assert recordMetadata != null;
        /**
         * 偏移量：偏移量（Consumer Offset）是一种元数据，它是一个不断递增的整数值，用来记录消费者发生重平衡时的位置，以便用来恢复数据
         * broker: 一个独立的 Kafka 服务器就被称为 broker，broker 接收来自生产者的消息，为消息设置偏移量，并提交消息到磁盘保存
         * broker 集群：broker 是集群 的组成部分，broker 集群由一个或多个 broker 组成，每个集群都有一个 broker 同时充当了集群控制器的角色（自动从集群的活跃成员中选举出来）
         * 副本：Kafka 中消息的备份又叫做 副本（Replica），副本的数量是可以配置的，Kafka 定义了两类副本：领导者副本（Leader Replica） 和 追随者副本（Follower Replica），前者对外提供服务，后者只是被动跟随
         * 重平衡：Rebalance。消费者组内某个消费者实例挂掉后，其他消费者实例自动重新分配订阅主题分区的过程。Rebalance 是 Kafka 消费者端实现高可用的重要手段
         */
        System.out.println("partition:" + recordMetadata.partition());
        System.out.println("offset:" + recordMetadata.offset());
        System.out.println("topic:" + recordMetadata.topic());

        return recordMetadata;
    }


}
