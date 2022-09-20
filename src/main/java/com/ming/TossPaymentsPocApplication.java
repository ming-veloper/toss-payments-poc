package com.ming;

import com.ming.payments.client.PaymentApprovalProxy;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TossPaymentsPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(TossPaymentsPocApplication.class, args);
    }

    @Bean
    public PaymentApprovalProxy paymentApprovalProxy() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(PaymentApprovalProxy.class, "https://api.tosspayments.com");
    }

}
