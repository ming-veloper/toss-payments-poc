package com.ming.payments.domain.entity;

import com.ming.payments.domain.value.*;
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

    /**
     * 총 결제 금액입니다.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "total_amount"))
    })
    private Money totalAmount;

    /**
     * 취소할 수 있는 금액(잔고)입니다.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount"))
    })
    private Money balanceAmount;

    /**
     * 공급가액입니다.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "supplied_amount"))
    })
    private Money suppliedAmount;

    /**
     * 부가세입니다. (결제 금액 amount - 면세 금액 taxFreeAmount) / 11 후 소수점 첫째 자리에서 반올림해서 계산합니다.
     * <p>
     * (e.g. 결제 금액이 10,000원이고, 면세 금액이 3,000원이라면 부가세는 (10000-3000)/11 = 636.3636..을 반올림한 값 636원입니다.)
     * <p>
     * 더 자세한 내용은 복합 과세 <a href="https://docs.tosspayments.com/guides/tax">처리하기</a>에서 살펴보세요.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "vat"))
    })
    private Money vat;

    /**
     * 전체 결제 금액 중 면세 금액입니다. 값이 0으로 돌아왔다면 전체 결제 금액이 과세 대상입니다.
     * <p>
     * *일반 상점일 때는 모든 결제 금액이 과세에 해당하기 때문에 0이 돌아옵니다. 면세 상점, 복합 과세 상점일 때만 면세 금액이 돌아옵니다. 더 자세한 내용은 <a href="https://docs.tosspayments.com/guides/tax">복합 과세 처리하기</a>에서 살펴보세요.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "tax_free_amount"))
    })
    private Money taxFreeAmount;

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
    @OneToOne
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
