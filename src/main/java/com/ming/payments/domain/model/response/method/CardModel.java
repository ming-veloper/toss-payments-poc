package com.ming.payments.domain.model.response.method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardModel {

    /**
     * 카드로 결제한 금액입니다.
     */
    private Long amount;

    /**
     * 카드사 코드입니다.
     */
    private String company;

    /**
     * 카드번호입니다. 번호의 일부는 마스킹 되어 있습니다. 최대 길이는 20자입니다.
     */
    private String number;

    /**
     * 할부 개월 수입니다. 일시불인 경우 0입니다.
     */
    private Integer installmentPlanMonths;

    /**
     * 카드사 승인 번호입니다. 최대 길이는 8자입니다.
     */
    private String approveNo;

    /**
     * 카드사 포인트를 사용했는지 여부입니다.
     */
    private boolean useCardPoint;

    /**
     * 카드 종류입니다. 신용, 체크, 기프트 중 하나입니다.
     */
    private String cardType;

    /**
     * 카드의 소유자 타입입니다. 개인, 법인 중 하나입니다.
     */
    private String ownerType;

    /**
     * 카드 매출 전표를 확인할 수 있는 주소입니다.
     */
    private String receiptUrl;

    /**
     * 카드 결제의 매입 상태입니다. 아래와 같은 상태값을 가질 수 있습니다.
     * <p>
     * READY - 매입 대기
     * <p>
     * REQUESTED - 매입 요청됨
     * <p>
     * COMPLETED - 매입 완료
     * <p>
     * CANCEL_REQUESTED - 매입 취소 요청됨
     * <p>
     * CANCELED - 매입 취소 완료
     */
    private String acquireStatus;

    /**
     * 무이자 할부의 적용 여부입니다.
     */
    private boolean isInterestFree;

    /**
     * 무이자 할부가 적용된 결제일 때 할부 수수료를 부담하는 주체에 대한 정보입니다. BUYER, CARD_COMPANY, MERCHANT 중 하나입니다.
     * <p>
     * BUYER - 상품을 구매한 고객
     * <p>
     * CARD_COMPANY - 카드사
     * <p>
     * MERCHANT - 상점
     */
    private String interestPayer;
}
