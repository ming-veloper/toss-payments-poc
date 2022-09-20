package com.ming.payments.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCancelModel {

    /**
     * 결제를 취소한 금액입니다.
     */
    private Long cancelAmount;

    /**
     * 결제를 취소한 이유입니다. 최대 길이는 200자입니다.
     */
    private String cancelReason;

    /**
     * 취소된 금액 중 면세 금액입니다.
     */
    private Long taxFreeAmount;

    /**
     * 과세 처리된 금액입니다.
     */
    private Long taxAmount;

    /**
     * 결제 취소 후 환불 가능한 잔액입니다.
     */
    private Long refundableAmount;

    /**
     * 결제 취소가 일어난 날짜와 시간 정보입니다. ISO 8601 형식인 yyyy-MM-dd'T'HH:mm:ss±hh:mm입니다.
     * <p>
     * (e.g. 2022-01-01T00:00:00+09:00)
     */
    private String canceledAt;

    /**
     * 취소 건에 대한 고유한 키 값입니다. 여러 건의 취소 거래를 구분하는데 사용됩니다. 최대 길이는 64자입니다.
     */
    private String transactionKey;
}
