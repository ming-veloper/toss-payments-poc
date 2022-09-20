package com.ming.payments.client;

import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.domain.model.response.PaymentModel;
import feign.HeaderMap;
import feign.RequestLine;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Base64;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    PaymentModel processConfirmPayment(
            @HeaderMap Map<String, Object> headerMap,
            @RequestBody PaymentApprovalRequest request
    );

    default PaymentModel confirmPayment(String secretKey,
                                        PaymentApprovalRequest request) {
        Map<String, Object> headerMap = createHeader(secretKey);
        try {
            return processConfirmPayment(headerMap, request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private static Map<String, Object> createHeader(String secretKey) {
        Map<String, Object> headerMap = Map.of(
                HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString(secretKey.getBytes()),
                HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
        return headerMap;
    }


}
