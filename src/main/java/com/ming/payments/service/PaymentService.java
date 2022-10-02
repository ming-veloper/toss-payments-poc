package com.ming.payments.service;

import com.ming.config.TossPaymentsConfiguration;
import com.ming.order.domain.entity.Order;
import com.ming.order.service.OrderService;
import com.ming.payments.client.PaymentApprovalProxy;
import com.ming.payments.domain.entity.PaymentHistory;
import com.ming.payments.domain.model.request.PaymentApprovalRequest;
import com.ming.payments.domain.model.response.PaymentModel;
import com.ming.payments.domain.value.PaymentMethod;
import com.ming.payments.repository.PaymentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class PaymentService {

    //TODO 결제 한 Payment 객체에 대해 어떻게 처리할 지 ... 그리고 Entity 를 어떻게 가공할 지 고민해보기
    private final PaymentApprovalProxy proxy;
    private final PaymentHistoryRepository repository;
    private final TossPaymentsConfiguration configuration;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public void success(PaymentApprovalRequest request) {
        //TODO 결제 금액 같은지 검증 필요한데,,, 그냥 했다 치자~
        PaymentModel paymentModel = proxy.confirmPayment(configuration.getSecretKey(), request);
        if (!paymentModel.getStatus().equals("DONE")) {
            throw new RuntimeException("Payment failed");
        }
        orderService.completeOrder(paymentModel.getOrderId());
        var paymentHistory = modelMapper.map(paymentModel, PaymentHistory.class);
        save(paymentModel, paymentHistory);
    }

    private void save(PaymentModel paymentModel, PaymentHistory paymentHistory) {
        paymentHistory.setOrder(Order.of(paymentModel.getOrderId()));
        paymentHistory.setId(paymentModel.getPaymentKey());
        paymentHistory.setMethod(PaymentMethod.findByDescription(paymentModel.getMethod()));
        paymentHistory.setRequestedAt(LocalDateTime.parse(paymentModel.getRequestedAt(), DateTimeFormatter.ISO_DATE_TIME));
        paymentHistory.setApprovedAt(LocalDateTime.parse(paymentModel.getApprovedAt(), DateTimeFormatter.ISO_DATE_TIME));
        repository.save(paymentHistory);
    }


}
