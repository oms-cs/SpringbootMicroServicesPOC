package com.poc.stock.enquiryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnquiryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnquiryMsApplication.class, args);
	}

}
