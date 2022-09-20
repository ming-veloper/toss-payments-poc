package com.ming.payments.domain.model.response.method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EasyPayModel {

    /**
     * 선택한 <a href="https://docs.tosspayments.com/reference/enum-codes#%EA%B0%84%ED%8E%B8%EA%B2%B0%EC%A0%9C-%EC%84%9C%EB%B9%84%EC%8A%A4">간편결제</a> 서비스 코드입니다.
     */
    private String provider;

    /**
     * 간편결제 서비스에 등록된 카드, 계좌 중 하나로 결제한 금액입니다.
     */
    private Long amount;

    /**
     * 간편결제 서비스의 적립 포인트나 쿠폰 등을 사용해서 즉시 할인된 금액입니다.
     */
    private Long discountAmount;
}
