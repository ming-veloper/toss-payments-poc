package com.ming.payments.entity.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PaymentKey implements Serializable {

    /**
     * 결제 건에 대한 고유한 키 값입니다. 최대 길이는 200자입니다.
     */
    @Column(name = "payment_key")
    private String paymentKey;
}
