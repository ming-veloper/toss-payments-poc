package com.ming.order.controller

import com.ming.order.model.OrderDto
import com.ming.order.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

typealias OrderList = List<OrderDto>

@RestController
@RequestMapping("/api/order")
class OrderListController(
    private val orderService: OrderService
) {

    @GetMapping
    fun getOrders(): ResponseEntity<OrderList> {
        val orders = orderService.orders
        return ResponseEntity.ok(orders)
    }
}