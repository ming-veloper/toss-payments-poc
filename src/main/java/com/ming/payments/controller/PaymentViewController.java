package com.ming.payments.controller;

import com.ming.config.TossPaymentsConfiguration;
import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PaymentViewController {

    private final TossPaymentsConfiguration configuration;
    private final PaymentService paymentService;

    @GetMapping
    public String paymentView() {
        return "index";
    }

    @GetMapping("/success")
    public String paymentSuccess(PaymentApprovalRequest request) {
        paymentService.success(request);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/key")
    public String getKey() {
        return configuration.getClientKey();
    }

}
