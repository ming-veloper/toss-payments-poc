package com.ming.order.service;

import com.ming.order.client.ProductServiceProxy;
import com.ming.order.domain.entity.Order;
import com.ming.order.domain.model.OrderRequest;
import com.ming.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductServiceProxy productService;
    private final OrderRepository orderRepository;

    public String processOrder(OrderRequest request) {
        var product = productService.getProduct(request.getProductId());
        Order order = new Order(request.getOrdererName(), product.getAmount(), product.getProductName());
        return orderRepository.save(order).getOrderId();
    }
}
