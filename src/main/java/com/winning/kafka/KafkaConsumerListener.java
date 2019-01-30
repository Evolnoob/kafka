package com.winning.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class KafkaConsumerListener implements MessageListener<Integer, String> {
    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
        String value = integerStringConsumerRecord.value();
        System.out.println(value);
        String str = JSONObject.toJSONString(integerStringConsumerRecord);
        System.out.println(str);
    }
}
