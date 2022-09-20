package com.ming.payments.domain.model.response.method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VirtualAccountModel {

    /**
     * 가상계좌 타입을 나타냅니다. 일반, 고정 중 하나입니다.
     */
    private String accountType;

    /**
     * 발급된 계좌 번호입니다. 최대 길이는 20자입니다.
     */
    private String accountNumber;

    /**
     * 가상계좌를 발급한 은행입니다.
     */
    private String bank;

    /**
     * 가상계좌를 발급한 고객 이름입니다. 최대 길이는 100자입니다.
     */
    private String customerName;

    /**
     * 입금 기한입니다.
     */
    private String dueDate;

    /**
     * 환불처리 상태입니다. 아래와 같은 상태값을 가질 수 있습니다.
     * <p>
     * NONE - 해당 없음
     * <p>
     * FAILED - 환불 실패
     * <p>
     * PENDING - 환불 처리중
     * <p>
     * PARTIAL_FAILED - 부분환불 실패
     * <p>
     * COMPLETED - 환불 완료
     */
    private String refundStatus;

    /**
     * 가상계좌가 만료되었는지 여부입니다.
     */
    private boolean expired;

    /**
     * 정산 상태입니다. 정산이 아직 되지 않았다면 INCOMPLETE, 정산이 완료됐다면 COMPLETE 값이 들어옵니다.
     */
    private String settlementStatus;

}
