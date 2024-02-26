package com.poc.stock.enquiryms.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.poc.stock.enquiryms.model.Stock;

import jakarta.annotation.PostConstruct;

@Repository
public class StockRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockRepository.class);
	
	@PostConstruct
	public void setup() {
		LOGGER.info("Post Construct Stock Repository Setup");
		Stock stock1 = new Stock(101, "Tata Technologies", 541);
		Stock stock2 = new Stock(102, "Tata Consultancy Services", 981);
		Stock stock3 = new Stock(103, "Infosys Limited", 698);
		Stock stock4 = new Stock(104, "Persistent Technologies", 1098);
		
		stockList.add(stock1);
		stockList.add(stock2);
		stockList.add(stock3);
		stockList.add(stock4);
		
		LOGGER.info("Post Construct Stock Repository Setup Completed : stockList = "+stockList.toString());
	}
	
	List<Stock> stockList = new ArrayList<>();
	
	
	public Stock addStock(Stock stock) {
		stockList.add(stock);
		return stock;
	}
	
	public void deleteStockById(int id) {
		for(Stock stock : stockList) {
			if(stock.getStockId() == id) {
				stockList.remove(stock);
			}
		}
	}
	
	public List<Stock> findAll(){
		return stockList;
	}
	
	public Stock findById(int stockId) {
		
		Optional<Stock> findStock = stockList.stream()
						.filter(stock -> stock.getStockId()== stockId).findFirst();
		
		return findStock.orElse(null);
	}

}
