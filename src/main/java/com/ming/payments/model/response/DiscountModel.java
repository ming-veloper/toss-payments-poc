package com.ming.payments.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountModel {

    /**
     * 카드사의 즉시 할인 프로모션을 적용한 금액입니다.
     */
    private Long amount;

}
