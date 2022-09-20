package com.ming.payments.entity.value;

import javax.persistence.Embeddable;

@Embeddable
public class Receipt {

    /**
     * 영수증을 확인할 수 있는 주소입니다.
     */
    private String url;
}
