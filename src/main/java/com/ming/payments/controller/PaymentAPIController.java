package com.ming.payments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentAPIController {

    private final PaymentService paymentService;

    @GetMapping("/success")
    public String test(PaymentApprovalRequest request) throws JsonProcessingException {
        paymentService.doSomething(request);
        return "";
    }
}
