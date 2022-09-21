package com.ming.payments.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ming.config.TossPaymentsConfiguration;
import com.ming.payments.client.PaymentApprovalProxy;
import com.ming.payments.client.PaymentProxy;
import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.domain.model.response.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    //TODO 결제 한 Payment 객체에 대해 어떻게 처리할 지 ... 그리고 Entity 를 어떻게 가공할 지 고민해보기
    private final PaymentProxy paymentProxy;
    private final TossPaymentsConfiguration configuration;
    private final PaymentApprovalProxy proxy;

    public void doSomething(PaymentApprovalRequest request) throws JsonProcessingException {
        //TODO 결제 금액 같은지 검증 필요한데,,, 그냥 했다 치자~
        PaymentModel paymentModel = proxy.confirmPayment(configuration.getSecretKey(), request);
        System.out.println("request = " + request);
    }


}
