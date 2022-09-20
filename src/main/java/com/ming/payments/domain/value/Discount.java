package com.ming.payments.domain.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Discount {

    /**
     * 카드사의 즉시 할인 프로모션을 적용한 금액입니다.
     */
    @Column(name = "discount_amount")
    private Long amount;
}
