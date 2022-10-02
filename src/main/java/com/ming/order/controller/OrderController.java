package com.ming.order.controller;

import com.ming.order.domain.model.OrderCancelRequest;
import com.ming.order.domain.model.OrderRequest;
import com.ming.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<String> order(@RequestBody OrderRequest request) {
        String orderId = orderService.processOrder(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderId);
    }

    @PostMapping("/cancel")
    public ResponseEntity<Void> cancelOrder(@RequestBody OrderCancelRequest request) {
        orderService.cancelOrder(request);
        return ResponseEntity
                .ok()
                .build();
    }

}
