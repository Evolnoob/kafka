package com.winning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class TestController {
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @RequestMapping("/test")
    @ResponseBody
    public Map test(String topic) throws ExecutionException, InterruptedException {
        kafkaTemplate.setDefaultTopic(topic);
        if ("test".equals(topic)) {
            kafkaTemplate.sendDefault("测试消息发布~。~");
        } else if ("pubg".equals(topic)) {
            kafkaTemplate.sendDefault("pubg,一款吃鸡游戏，有挂逼，狗逼，和老阴逼。挂逼：开外挂者；狗逼：不杀人，只跑毒一路躲躲藏藏到决赛圈。老阴逼：想杀人，但不主动找人杀，会想着去阴别人。");
        }
        Map resultMap = new HashMap<>();
        resultMap.put("mag", "success");
        return resultMap;
    }
}
