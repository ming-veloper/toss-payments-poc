package com.ming.payments.domain.model.response.method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiftCertificateModel {

    /**
     * 결제 승인번호입니다. 최대 길이는 8자입니다.
     */
    private String approveNo;

    /**
     * 정산 상태입니다. 정산이 아직 되지 않았다면 INCOMPLETE, 정산이 완료됐다면 COMPLETE 값이 들어옵니다.
     */
    private String settlementStatus;
}
