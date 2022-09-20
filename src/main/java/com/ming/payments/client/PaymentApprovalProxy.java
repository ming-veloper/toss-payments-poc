package com.ming.payments.client;

import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import feign.HeaderMap;
import feign.Headers;
import feign.RequestLine;

import java.util.Map;

public interface PaymentApprovalProxy {

    /**
     * paymentKey에 해당하는 결제를 검증하고 승인합니다.
     * <p>
     * * 결제 승인 엔드포인트가 /v1/payments/{paymentKey}에서 /v1/payments/confirm으로 변경되었습니다. 이전 엔드포인트는 사용을 권장하지 않습니다.
     *
     * @param request 결제 요청이 담긴 객체입니다.
     * @return test
     */
    @RequestLine("POST /v1/payments/confirm")
    @Headers({"Content-Type: application/json"})
    Map<String, Object> confirmPayment(
            @HeaderMap Map<String, Object> headers,
            PaymentApprovalRequest request
    );

}
