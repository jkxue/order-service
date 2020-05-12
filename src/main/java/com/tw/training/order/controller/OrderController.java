package com.tw.training.order.controller;

import java.util.Date;
import java.util.UUID;

import com.tw.training.order.service.OrderService;
import com.tw.training.order.domain.OrderDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tw.training.order.db.OrderRepository;

// 订单服务
@RestController
@RequestMapping("/order")
public class OrderController {
	static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@RequestMapping("/new/{goodsId}")
	public String add(@PathVariable("goodsId") long goodsId, @RequestHeader(name = "phone") String phone,
			@RequestHeader(name = "email") String email) throws Exception {
		// 新增订单
		OrderDomain order = new OrderDomain();
		order.setOrderId(UUID.randomUUID().toString());
		order.setCreateTime(new Date());
		order.setEmail(email);
		order.setPhone(phone);
		order.setGoodsId(goodsId);
		orderService.save(order);
		logger.info("下单成功，订单信息：{}", order);
		return "success";
	}

}
