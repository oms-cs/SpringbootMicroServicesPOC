package com.poc.stock.stockexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.stock.stockexchange.config.EnquiryClient;
import com.poc.stock.stockexchange.model.Stock;
import com.poc.stock.stockexchange.service.KafkaProducer;


@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	private EnquiryClient enquiryClient;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping("/order/{stockId}")
	public String placeOrder(@PathVariable int stockId) {
		
		LOGGER.info("Exchange Controller /order/stockId:{} Endpoint Accessed. ",stockId);
		Stock result = enquiryClient.enquiryStock(stockId);
		String output = "Order Placed for stock : "+result.getStockName();
		LOGGER.info(output);
		kafkaProducer.sendOrderPlacedNotification(result);
		return output;
	}

}
