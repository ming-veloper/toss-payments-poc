package com.ming.payments.domain.value;

//TODO
// TossPayments 측에서는 이렇게 한글로 넘겨 주는 값들을 ENUM으로 매핑하려 하는데
// 그냥 ENUM도 한글로 할 지... 아니면 컨버터를 구현해서 영어로 매핑할지... 고민해보기🤓
public enum PaymentMethod {

    카드,
    가상계좌,
    간편결제,
    휴대폰,

}
