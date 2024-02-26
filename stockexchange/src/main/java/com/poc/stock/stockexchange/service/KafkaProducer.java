package com.poc.stock.stockexchange.service;

//@Service
public class KafkaProducer {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
//
//    @Value("${com.poc.stock.kafka.topic-name}")
//    private String kafkaTopic;
//
//    @Autowired
//    private KafkaTemplate<String, Stock> kafkaTemplate;
//
//    public void sendOrderPlacedNotification(Stock orderStock){
//    	LOGGER.info("Producing Message Notification for Order Placed on Topic {}",kafkaTopic);
//        Message<Stock> message = MessageBuilder
//                .withPayload(orderStock)
//                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
//                .build();
//        
//        LOGGER.info("Message {} Sending on Kafka Topic.",message);
//        kafkaTemplate.send(message);
//    }
}