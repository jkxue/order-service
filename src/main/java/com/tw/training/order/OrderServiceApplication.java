package com.tw.training.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 订单服务
@SpringBootApplication
@ComponentScan("com.tw")
@EnableEurekaClient	
@EnableCircuitBreaker // hystrix熔断
@EnableFeignClients // feign
@EnableTransactionManagement // 事务
@EnableJpaRepositories(basePackages = { "com.tw.training" })
public class OrderServiceApplication {
	final static Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderServiceApplication.class)
				.web(true).run(args);
		logger.info("OrderService 已经启动");
	}
}
