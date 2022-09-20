package com.ming.payments.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceiptModel {

    /**
     * 영수증을 확인할 수 있는 주소입니다.
     */
    private String url;
}
