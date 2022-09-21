package com.ming.payments.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.domain.model.response.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RequiredArgsConstructor
public class PaymentProxy {

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;


    public PaymentModel confirmPayment(String secretKey, PaymentApprovalRequest request) throws JsonProcessingException {
        secretKey += ":";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString(secretKey.getBytes()));
        var body = new HttpEntity<>(objectMapper.writeValueAsString(request), headers);

        var response =
                restTemplate.postForEntity("https://api.tosspayments.com/v1/payments/confirm", body, PaymentModel.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException();
        }
    }

}
