package com.ming.payments.model.response.method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MobilePhoneModel {

    /**
     * 결제에 사용한 휴대폰 번호입니다.
     */
    private String customerMobilePhone;

    /**
     * 정산 상태입니다. 정산이 아직 되지 않았다면 INCOMPLETE, 정산이 완료됐다면 COMPLETE 값이 들어옵니다.
     */
    private String settlementStatus;

    /**
     * 휴대폰 결제 내역 영수증을 확인할 수 있는 주소입니다.
     */
    private String receiptUrl;
}
