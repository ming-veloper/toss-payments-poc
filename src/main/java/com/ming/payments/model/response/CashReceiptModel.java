package com.ming.payments.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashReceiptModel {

    /**
     * 현금영수증의 키 값입니다. 최대 길이는 200자입니다.
     */
    private String receiptKey;

    /**
     * 현금영수증의 종류입니다. 소득공제, 지출증빙 중 하나의 값입니다.
     */
    private String type;

    /**
     * 현금영수증 처리된 금액입니다.
     */
    private Long amount;

    /**
     * 면세 처리된 금액입니다.
     */
    private Long taxFreeAmount;

    /**
     * 현금영수증 발급 번호입니다. 최대 길이는 9자 이하여야 합니다.
     */
    private String issueNumber;

    /**
     * 발행된 현금영수증을 확인할 수 있는 주소입니다.
     */
    private String receiptUrl;


}
