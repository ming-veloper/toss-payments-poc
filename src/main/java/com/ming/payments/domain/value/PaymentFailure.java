package com.ming.payments.domain.value;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentFailure {

    /**
     * 오류 타입을 보여주는 에러 코드입니다.
     */
    private String code;

    /**
     * 에러 메시지입니다. 에러 발생 이유를 알려줍니다. 최대 길이는 200자입니다.
     */
    private String message;
}
