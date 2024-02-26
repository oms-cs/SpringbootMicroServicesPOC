package com.poc.stock.enquiryms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.stock.enquiryms.model.Stock;
import com.poc.stock.enquiryms.repository.StockRepository;

@Service
public class EnquiryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnquiryService.class);
	
	@Autowired
	private StockRepository stockRepository;
	
	public Stock findStock(int id) {
		LOGGER.info("Stock Enquiry Service findStock Method Called for id {}.",id);
		var stock = stockRepository.findById(id);
		LOGGER.info("Found Stock {} for id {}, Return.",stock,id);
		return stock;
	}

}
