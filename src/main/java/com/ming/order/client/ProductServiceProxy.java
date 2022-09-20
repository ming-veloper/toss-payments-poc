package com.ming.order.client;

import com.ming.order.client.model.ProductModel;

public interface ProductServiceProxy {

    /**
     * 상품 번호로 해당하는 상품을 가져옵니다.
     *
     * @param productId 상품 번호
     * @return 해당하는 상품
     */
    ProductModel getProduct(Long productId);

}
