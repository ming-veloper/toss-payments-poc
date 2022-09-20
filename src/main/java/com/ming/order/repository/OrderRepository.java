package com.ming.order.repository;

import com.ming.order.domain.entity.Order;
import com.ming.order.domain.value.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
