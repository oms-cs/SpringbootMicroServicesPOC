package com.poc.stock.stockexchange.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poc.stock.stockexchange.model.Stock;
import com.poc.stock.stockexchange.util.AppConstants;

@FeignClient(value = AppConstants.ENQUIRY_APPLICATION)
public interface EnquiryClient {
	
	@RequestMapping(method = RequestMethod.GET, value = AppConstants.ENQUIRY_ENDPOINT)
    String enquiry();
	
	@RequestMapping(method = RequestMethod.GET, value = AppConstants.STOCK_ID_ENQUIRY_ENDPOINT)
	Stock enquiryStock(@PathVariable("stockId") int stockId);
}
