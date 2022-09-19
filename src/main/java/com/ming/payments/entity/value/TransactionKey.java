package com.ming.payments.entity.value;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionKey {

    /**
     * 마지막 거래 건에 대한 고유한 키 값입니다. 결제 한 건에 대한 승인 거래와 취소 거래를 구분하는데 사용됩니다. 최대 길이는 64자입니다.
     * <p>
     * * 다음 버전부터 transactionKey를 지원하지 않습니다. lastTransactionKey를 사용해주세요.
     */
    private String transactionKey;

    /**
     * 마지막 거래 건에 대한 고유한 키 값입니다.
     * <p>
     * 결제 한 건에 대한 승인 거래와 취소 거래를 구분하는데 사용됩니다.
     * <p>
     * 예를 들어 결제 승인 후 부분 취소를 두 번 했다면 마지막 부분 취소 거래 건에 대한 키 값이 할당됩니다.
     * <p>
     * 최대 길이는 64자입니다.
     */
    private String lastTransactionKey;
}
