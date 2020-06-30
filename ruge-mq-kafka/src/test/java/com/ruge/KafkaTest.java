package com.ruge;

import com.ruge.server.KafkaProducer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName KafkaTest
 * @date 2020.06.29 15:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RugeKafkaApplication.class)
public class KafkaTest {
    @Resource
    private KafkaProducer kafkaProducer;

    @Test
    public void testSend() {
        String topic = "springboot-topic1";
        String message = "如歌测试_" + UUID.randomUUID();
        RecordMetadata recordMetadata = kafkaProducer.sendChannelMess(topic, message);
        System.out.println("返回值~~~");
        System.out.println(recordMetadata.toString());
    }

}
