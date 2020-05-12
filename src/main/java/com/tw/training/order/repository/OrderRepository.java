package com.tw.training.order.db;

import com.tw.training.order.domain.OrderDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDomain, String> {
}