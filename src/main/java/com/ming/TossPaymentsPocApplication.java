package com.ming;

import com.ming.payments.client.PaymentApprovalProxy;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;

@EnableAsync
@SpringBootApplication
public class TossPaymentsPocApplication {

    public static void main(String[] args) {
        Map<String, Object> systemEnvironment = new StandardEnvironment().getSystemEnvironment();
        for (String s : systemEnvironment.keySet()) {
            System.out.println(s + " : " + systemEnvironment.get(s));
        }
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
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
