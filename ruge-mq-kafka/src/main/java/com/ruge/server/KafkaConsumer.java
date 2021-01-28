package com.ruge.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Consumer
 * @date 2020.06.29 15:14
 */
@Slf4j
@Component
public class KafkaConsumer {

    /**
     * 有消息就读取,只读取消息value
     */
    @KafkaListener(topics = {"hw1-msg_push_jpush"})
    public void receiveMessage(Object message) {
        //收到通道的消息之后执行秒杀操作
        log.error("hw1-msg_push_jpush:{}", message);
    }

    @KafkaListener(topics = {"msg_push_jpush"})
    public void receiveMessage2(Object message) {
        log.error("msg_push_jpush:{}", message);
    }

    /**
     * 有消息就读取,批量读取消息value
     */
    @KafkaListener(topics = "test12")
    public void onMessage(List<String> crs) {
        for (String str : crs) {
            System.out.println("test12:" + str);
        }
    }

    /**
     * 有消息就读取,读取消息topic，offset，key，value等信息
     */
    @KafkaListener(topics = "test14")
    public void listenT1(ConsumerRecord<?, ?> cr) {
        System.out.println("listenT1收到消息,topic:>>>" + cr.topic() + "  offset:>>" + cr.offset() + "  key:>>" + cr.key() + "  value:>>" + cr.value());
    }
}
