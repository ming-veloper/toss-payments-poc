package com.ming.payments.entity.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class EasyPay {

    /**
     * 선택한 간편결제 서비스 코드입니다.
     */
    private String provider;

    /**
     * 간편결제 서비스에 등록된 카드, 계좌 중 하나로 결제한 금액입니다.
     */
    @Column(name = "easy_pay_amount")
    private Long amount;

    /**
     * 간편결제 서비스의 적립 포인트나 쿠폰 등을 사용해서 즉시 할인된 금액입니다.
     */
    private Long discountAmount;


}
