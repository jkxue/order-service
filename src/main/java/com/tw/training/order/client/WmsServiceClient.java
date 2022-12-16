package com.tw.training.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wms-service", path = "/wms")
public interface WmsServiceClient {

	// 锁定库存
	@RequestMapping(value = "/goods-stock/{goodsId}/sub-stock", method = RequestMethod.POST)
	String subStock(@PathVariable("goodsId") Long goodsId, @RequestParam(value = "number") Integer number);
}