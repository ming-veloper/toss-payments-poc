package com.ming.payments.controller;

import com.ming.config.TossPaymentsConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PaymentViewController {

    private final TossPaymentsConfiguration configuration;

    @GetMapping
    public String paymentView(Model model) {
        model.addAttribute("clientKey", configuration.getClientKey());
        return "index";
    }
}
