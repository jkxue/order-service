package com.tw.training.order.service;

import com.tw.training.order.domain.OrderDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tw.training.order.client.WmsServiceClient;
import com.tw.training.order.db.OrderRepository;

@Service
@Transactional(rollbackFor=Throwable.class)
public class OrderService {
	static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	Tracer tracer;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	WmsServiceClient wmsServiceClient;

	public void save(OrderDomain order) throws Exception {
		orderRepository.save(order);
		// 减库存
		String subStockResult = wmsServiceClient.subStock(order.getGoodsId());
		if (subStockResult == null) {
			throw new Exception("下单失败[请联系客服]");
		}
	}
}
