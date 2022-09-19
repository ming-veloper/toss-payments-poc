package com.ming.payments.entity;

import com.ming.payments.entity.value.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @EmbeddedId
    private PaymentKey paymentKey;

    private String version;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Embedded
    private OrderHistory orderHistory;

    @Embedded
    private StoreId storeId;

    @Embedded
    private Amount amount;

    /**
     * 결제할 때 사용한 통화 단위입니다. 원화인 KRW만 사용합니다.
     */
    private String currency;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    /**
     * 결제 처리 상태입니다.
     */
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    /**
     * 결제 요청이 일어난 날짜와 시간 정보입니다. ISO 8601 형식인 yyyy-MM-dd'T'HH:mm:ss.SSS±hh:mm으로 돌아옵니다.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime requestedAt;

    /**
     * 결제 승인이 일어난 날짜와 시간 정보입니다. ISO 8601 형식인 yyyy-MM-dd'T'HH:mm:ss.SSS±hh:mm으로 돌아옵니다.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime approvedAt;

    /**
     * 에스크로 사용 여부입니다.
     */
    private boolean useEscrow;

    @Embedded
    private TransactionKey transactionKey;

    /**
     * 문화비로 지출했는지 여부입니다. (도서구입, 공연 티켓, 박물관·미술관 입장권 등)
     */
    private boolean cultureExpense;

    //TODO cancels 배열 처리 어떻게 할 지 정하기
    /////

    /**
     * 카드로 결제하면 제공되는 카드 관련 정보입니다.
     */
    @Embedded
    private Card card;

    /**
     * 발행된 영수증 정보입니다.
     */
    @Embedded
    private Receipt receipt;

    /**
     * 결제한 국가 정보입니다. <a href="https://ko.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO-3166</a>의 두 자리 국가 코드 형식입니다.
     */
    private String country;

    /**
     * 결제 실패 정보입니다.
     */
    @Embedded
    private PaymentFailure failure;

    /**
     * 카드사의 즉시 할인 프로모션 정보입니다. 즉시 할인 프로모션이 적용됐을 때만 생성됩니다.
     */
    @Embedded
    private Discount discount;
}
