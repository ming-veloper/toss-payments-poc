package com.ming.payments.entity.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StoreId {

    /**
     * 상점아이디(MID)입니다. 토스페이먼츠에서 상점을 구분하기 위해 발급한 고유 ID입니다. 최대 길이는 14자입니다.
     */
    @Column(name = "mId")
    private String id;
}
