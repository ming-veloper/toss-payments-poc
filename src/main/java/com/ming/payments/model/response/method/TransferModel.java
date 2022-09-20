package com.ming.payments.model.response.method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferModel {

    /**
     * 이체할 은행입니다. <a href="https://docs.tosspayments.com/reference/codes#%EC%9D%80%ED%96%89-%EC%BD%94%EB%93%9C">은행 코드</a>를 참고하세요.
     */
    private String bank;

    /**
     * 정산 상태입니다. 정산이 아직 되지 않았다면 INCOMPLETE, 정산이 완료됐다면 COMPLETE 값이 들어옵니다.
     */
    private String settlementStatus;
}
