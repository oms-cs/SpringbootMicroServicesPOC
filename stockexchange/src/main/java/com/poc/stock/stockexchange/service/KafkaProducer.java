package com.poc.stock.stockexchange.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.poc.stock.stockexchange.model.Stock;

@Service
public class KafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${com.poc.stock.kafka.topic-name}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, Stock> kafkaTemplate;

    public void sendOrderPlacedNotification(Stock orderStock){
    	LOGGER.info("Producing Message Notification for Order Placed on Topic {}",kafkaTopic);
        Message<Stock> message = MessageBuilder
                .withPayload(orderStock)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();
        
        LOGGER.info("Message {} Sending on Kafka Topic.",message);
        kafkaTemplate.send(message);
    }
}