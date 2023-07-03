package com.tw.training.order.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PrometheusCustomMonitor {

    private Counter requestErrorCount;
    private Counter orderCount;

    private final MeterRegistry registry;

    @Autowired
    public PrometheusCustomMonitor(MeterRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    private void init() {
        requestErrorCount = registry.counter("requests_error_total", "status", "error");
        orderCount = registry.counter("order_request_count", "order", "order-service");
    }

    public Counter getRequestErrorCount() {
        return requestErrorCount;
    }

    public Counter getOrderCount() {
        return orderCount;
    }
}

