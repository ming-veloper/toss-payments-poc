package com.ming.payments.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentApprovalRequest {

    /**
     * 결제 건에 대한 고유한 키값입니다. 최대 길이는 200자입니다.
     */
    private String paymentKey;

    /**
     * 상점에서 주문 건을 구분하기 위해 발급한 고유 ID입니다. 영문 대소문자, 숫자, 특수문자(-, _)로 이루어진 6자 이상 64자 이하의 문자열이어야 합니다.
     */
    private String orderId;

    /**
     * 결제할 금액입니다.
     */
    private Long amount;

}
