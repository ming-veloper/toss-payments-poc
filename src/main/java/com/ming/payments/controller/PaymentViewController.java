package com.ming.payments.controller;

import com.ming.OrderDto;
import com.ming.config.TossPaymentsConfiguration;
import com.ming.order.service.OrderService;
import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentViewController {

    private final TossPaymentsConfiguration configuration;
    private final PaymentService paymentService;
    private final OrderService orderService;

    @GetMapping
    public String paymentView(Model model) {
        List<OrderDto> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("clientKey", configuration.getClientKey());
        return "index";
    }

    @GetMapping("/success")
    public String test(PaymentApprovalRequest request) {
        paymentService.doSomething(request);
        return "redirect:/";
    }
}
