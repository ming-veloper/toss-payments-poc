package com.ming.payments.entity.value;

import javax.persistence.Embeddable;

@Embeddable
public class Amount {

    /**
     * 총 결제 금액입니다.
     */
    private Long totalAmount;

    /**
     * 취소할 수 있는 금액(잔고)입니다.
     */
    private Long balanceAmount;

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
     * 전체 결제 금액 중 면세 금액입니다. 값이 0으로 돌아왔다면 전체 결제 금액이 과세 대상입니다.
     * <p>
     * *일반 상점일 때는 모든 결제 금액이 과세에 해당하기 때문에 0이 돌아옵니다. 면세 상점, 복합 과세 상점일 때만 면세 금액이 돌아옵니다. 더 자세한 내용은 <a href="https://docs.tosspayments.com/guides/tax">복합 과세 처리하기</a>에서 살펴보세요.
     */
    private Long taxFreeAmount;

}
