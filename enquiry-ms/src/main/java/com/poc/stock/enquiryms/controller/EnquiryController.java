package com.poc.stock.enquiryms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.stock.enquiryms.model.Stock;
import com.poc.stock.enquiryms.service.EnquiryService;

@RestController
@RequestMapping("/api/v1/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EnquiryController.class);
	
	@GetMapping("/")
	public String enquiry() {
		LOGGER.info("/enquiry/ Endpoint Accessed !");
		return "EnquiryObject";
	}
	@GetMapping("/{id}")
	public Stock getStockDetails(@PathVariable int id) {
		LOGGER.info("Stock Enquired from PathVariable id = {}.",id);
		Stock outStock = enquiryService.findStock(id);
		return outStock;
	}

}
