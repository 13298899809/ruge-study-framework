package com.ruge.controller;

import com.ruge.server.KafkaProducer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author ruge.wu
 * @Description //TODO kafka$
 * @Date 2021/1/12 15:39
 **/
@RestController
public class KafkaController {

    @Resource
    private KafkaProducer kafkaProducer;

    @GetMapping("submit")
    public RecordMetadata submit(String topic) {
        Object message = UUID.randomUUID().toString();
        return kafkaProducer.sendChannelMess(topic, message);
    }
}
