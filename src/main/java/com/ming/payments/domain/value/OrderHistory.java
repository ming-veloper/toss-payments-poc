package com.ming.payments.domain.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderHistory {

    /**
     * 상점에서 주문 건을 구분하기 위해 발급한 고유 ID입니다. 최소 길이는 6자, 최대 길이는 64자입니다.
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 결제에 대한 주문명입니다. 예를 들면 생수 외 1건 같은 형식입니다. 최대 길이는 100자입니다.
     */
    @Column(name = "order_name")
    private String orderName;
}
