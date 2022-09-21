package com.ming;

import com.ming.payments.client.PaymentApprovalProxy;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TossPaymentsPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(TossPaymentsPocApplication.class, args);
    }

    @Bean
    public PaymentApprovalProxy paymentApprovalProxy() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(PaymentApprovalProxy.class))
                .logLevel(Logger.Level.FULL)
                .target(PaymentApprovalProxy.class, "https://api.tosspayments.com");
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return template;
    }

}
