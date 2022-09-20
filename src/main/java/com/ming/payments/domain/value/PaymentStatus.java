package com.ming.payments.domain.value;

public enum PaymentStatus {

    /**
     * 준비됨
     */
    READY,

    /**
     * 진행중
     */
    IN_PROGRESS,

    /**
     * 가상계좌 입금 대기 중
     */
    WAITING_FOR_DEPOSIT,

    /**
     * 결제 완료됨
     */
    DONE,

    /**
     * 결제가 취소됨
     */
    CANCELED,

    /**
     * 결제가 부분 취소됨
     */
    PARTIAL_CANCELED,

    /**
     * 카드 자동 결제 혹은 키인 결제를 할 때 결제 승인에 실패함
     */
    ABORTED,

    /**
     * 유효 시간(30분)이 지나 거래가 취소됨
     */
    EXPIRED
}
