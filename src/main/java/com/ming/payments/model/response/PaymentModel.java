package com.ming.payments.model.response;

import com.ming.payments.entity.value.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentModel {

    /**
     * Payment 객체의 응답 버전입니다. 버전 2022-06-08부터 날짜 기반 버저닝을 사용합니다.
     */
    private String version;

    /**
     * 결제 건에 대한 고유한 키 값입니다. 최대 길이는 200자입니다.
     */
    private String paymentKey;

    /**
     * 결제 타입 정보입니다. NORMAL(일반 결제), BILLING(자동 결제), BRANDPAY(브랜드페이) 중 하나입니다.
     */
    private String type;

    /**
     * 상점에서 주문 건을 구분하기 위해 발급한 고유 ID입니다. 최소 길이는 6자, 최대 길이는 64자입니다.
     */
    private String orderId;

    /**
     * 결제에 대한 주문명입니다. 예를 들면 생수 외 1건 같은 형식입니다. 최대 길이는 100자입니다.
     */
    private String orderName;

    /**
     * 상점아이디(MID)입니다. 토스페이먼츠에서 상점을 구분하기 위해 발급한 고유 ID입니다. 최대 길이는 14자입니다.ø
     */
    private String mId;

    /**
     * 결제할 때 사용한 통화 단위입니다. 원화인 KRW만 사용합니다.
     */
    private String currency;

    /**
     * 결제할 때 사용한 결제 수단입니다. 카드, 가상계좌, 간편결제, 휴대폰, 계좌이체, 상품권(문화상품권, 도서문화상품권, 게임문화상품권) 중 하나입니다.
     */
    private String method;

    /**
     * 총 결제 금액입니다.
     */
    private Long totalAmount;

    /**
     * 취소할 수 있는 금액(잔고)입니다.
     */
    private Long balanceAmount;

    /**
     * 결제 처리 상태입니다. 아래와 같은 상태값을 가질 수 있습니다.
     * <p>
     * READY - 준비됨
     * <p>
     * IN_PROGRESS - 진행중
     * <p>
     * WAITING_FOR_DEPOSIT - 가상계좌 입금 대기 중
     * <p>
     * DONE - 결제 완료됨
     * <p>
     * CANCELED - 결제가 취소됨
     * <p>
     * PARTIAL_CANCELED - 결제가 부분 취소됨
     * <p>
     * ABORTED - 카드 자동 결제 혹은 키인 결제를 할 때 결제 승인에 실패함
     * <p>
     * EXPIRED - 유효 시간(30분)이 지나 거래가 취소됨
     */
    private String status;

    /**
     * 결제 요청이 일어난 날짜와 시간 정보입니다. ISO 8601 형식인 yyyy-MM-dd'T'HH:mm:ss±hh:mm으로 돌아옵니다.
     * <p>
     * (e.g. 2022-01-01T00:00:00+09:00)
     */
    private String requestedAt;

    /**
     * 결제 승인이 일어난 날짜와 시간 정보입니다. ISO 8601 형식인 yyyy-MM-dd'T'HH:mm:ss±hh:mm으로 돌아옵니다.
     */
    private String approvedAt;

    /**
     * 에스크로 사용 여부입니다.
     */
    private boolean useEscrow;

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
     * 예를 들어 결제 승인 후 부분 취소를 두 번 했다면 마지막 부분 취소 거래 건에 대한 키 값이 할당됩니다. 최대 길이는 64자입니다.
     */
    private String lastTransactionKey;

    /**
     * 공급가액입니다.
     */
    private Long suppliedAmount;

    /**
     * 부가세입니다. (결제 금액 amount - 면세 금액 taxFreeAmount) / 11 후 소수점 첫째 자리에서 반올림해서 계산합니다.
     * <p>
     * (e.g. 결제 금액이 10,000원이고, 면세 금액이 3,000원이라면 부가세는 (10000-3000)/11 = 636.3636..을 반올림한 값 636원입니다.)
     * <p>
     * 더 자세한 내용은 복합 과세 <a href="https://docs.tosspayments.com/guides/tax">처리하기</a>에서 살펴보세요.
     */
    private Long vat;

    /**
     * 문화비로 지출했는지 여부입니다. (도서구입, 공연 티켓, 박물관·미술관 입장권 등)
     */
    private boolean cultureExpense;

    /**
     * 전체 결제 금액 중 면세 금액입니다. 값이 0으로 돌아왔다면 전체 결제 금액이 과세 대상입니다.
     * <p>
     * *일반 상점일 때는 모든 결제 금액이 과세에 해당하기 때문에 0이 돌아옵니다. 면세 상점, 복합 과세 상점일 때만 면세 금액이 돌아옵니다. 더 자세한 내용은 <a href="https://docs.tosspayments.com/guides/tax">복합 과세 처리하기</a>에서 살펴보세요.
     */
    private Long taxFreeAmount;

    /**
     * 결제 취소 이력이 담기는 배열입니다.
     */
    private List<PaymentCancelModel> cancels = new ArrayList<>();

    /**
     * 부분 취소 가능 여부입니다. 이 값이 false이면 전액 취소만 가능합니다.
     */
    private boolean isPartialCancelable;

    /**
     * 카드로 결제하면 제공되는 카드 관련 정보입니다.
     */
    private Card card;

    /**
     * 발행된 영수증 정보입니다.
     */
    private ReceiptModel receipt;

    /**
     * 간편결제로 결제한 정보를 담은 객체입니다.
     */
    private EasyPayModel easyPay;

    /**
     * 결제한 국가 정보입니다. <a href="https://ko.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO-3166</a>의 두 자리 국가 코드 형식입니다.
     */
    private String country;

    /**
     * 결제 실패 정보입니다.
     */
    private PaymentFailureModel failure;

    /**
     * 현금영수증 정보입니다.
     */
    private CashReceiptModel cashReceipt;

    /**
     * 카드사의 즉시 할인 프로모션 정보입니다. 즉시 할인 프로모션이 적용됐을 때만 생성됩니다.
     */
    private DiscountModel discount;
}
