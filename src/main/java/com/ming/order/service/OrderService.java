package com.ming.order.service;

import com.ming.order.client.ProductServiceProxy;
import com.ming.order.domain.entity.Order;
import com.ming.order.domain.model.OrderCancelRequest;
import com.ming.order.domain.model.OrderRequest;
import com.ming.order.domain.value.OrderId;
import com.ming.order.exception.OrderNotFoundException;
import com.ming.order.model.OrderDto;
import com.ming.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final ProductServiceProxy productService;
    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public String processOrder(OrderRequest request) {
        var product = productService.getProduct(request.getProductId());
        Order order = new Order(request.getOrdererName(), product.getAmount(), product.getProductName());
        return orderRepository.save(order).getOrderId();
    }

    @Async
    @Transactional
    public void completeOrder(String orderIdString) {
        log.info(">>> current thread name : {}", Thread.currentThread().getName());
        OrderId orderId = OrderId.builder().id(orderIdString).build();
        orderRepository.findById(orderId)
                .ifPresent(Order::completeOrder);
    }

    public List<OrderDto> getOrders() {
        return orderRepository.findAll().stream()
                .map(e -> {
                    return modelMapper.map(e, OrderDto.class);
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void cancelOrder(OrderCancelRequest request) {
        orderRepository.findById(OrderId.of(request.getOrderId()))
                .ifPresentOrElse(Order::cancelOrder, () -> {
                    throw new OrderNotFoundException(request.getOrderId() + "에 해당하는 주문을 찾을 수 없습니다.");
                });
    }
}
