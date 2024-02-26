package com.poc.stock.notification.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${com.poc.stock.kafka.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void orderPlaced(String message){
    	LOGGER.info("consumed Message {} from Kafka topic ",message);
    	System.out.println("Consumed Message == "+message);
    }
}