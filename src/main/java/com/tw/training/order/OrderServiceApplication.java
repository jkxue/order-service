package com.tw.training.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 订单服务
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients// feign
@EnableTransactionManagement // 事务
public class OrderServiceApplication {
	final static Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		logger.info("OrderService 已经启动");
	}
}
