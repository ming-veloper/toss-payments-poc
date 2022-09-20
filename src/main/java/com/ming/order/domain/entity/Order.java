package com.ming.order.domain.entity;

import com.ming.order.domain.model.OrderStatus;
import com.ming.order.domain.value.OrderId;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private OrderId orderId = OrderId.generate();

    private String orderName;

    private Long amount;

    private String ordererName;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    protected Order() {
    }

    public Order(String ordererName, Long amount, String orderName) {
        assert orderName != null & amount != null & orderName != null;
        this.ordererName = ordererName;
        this.amount = amount;
        this.orderName = orderName;
        this.orderStatus = OrderStatus.PENDING;
    }

    public String getOrderId() {
        return orderId.getId();
    }

    public void cancelOrder() {
        this.orderStatus = OrderStatus.CANCELLED;
    }
}
