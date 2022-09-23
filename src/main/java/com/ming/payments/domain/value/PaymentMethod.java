package com.ming.payments.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {

    CARD("카드"),
    VIRTUAL_ACCOUNT("가상계좌"),
    EASY_PAY("간편결제"),
    MOBILE_PHONE("휴대폰"),
    GIFT_CERTIFICATE("상품권(문화상품권, 도서문화상품권, 게임문화상품권)"),
    TRANSFER("계좌이체");

    private final String description;

    public static PaymentMethod findByDescription(String description) {
        return Arrays.stream(PaymentMethod.values())
                .filter(i -> i.getDescription().equals(description))
                .findFirst()
                .orElseThrow();
    }

}
