package com.ming.order.client.impl;

import com.ming.order.client.ProductServiceProxy;
import com.ming.order.client.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FakeProductServiceProxy implements ProductServiceProxy {

    @Override
    public ProductModel getProduct(Long productId) {
        //TODO 서비스 간 IPC 를 통해 상품을 가져왔다고 가정하겠습니다.
        log.info(">>> productId={}", productId);
        return ProductModel.builder()
                .productName("토스 결제 테스트 상품")
                .amount(19_000L)
                .build();
    }
}
