package com.ming.order.model;

import com.ming.order.domain.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.ming.order.domain.entity.Order} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private String orderId;
    private String orderName;
    private Long amount;
    private String ordererName;
    private OrderStatus orderStatus;
}