package com.ming.payments.domain.entity;

import com.ming.order.domain.entity.Order;
import com.ming.payments.domain.value.PaymentMethod;
import com.ming.payments.domain.value.PaymentStatus;
import com.ming.payments.domain.value.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentHistory {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    private Long totalAmount;

    private Long balanceAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime requestedAt;

    private LocalDateTime approvedAt;

    private String lastTransactionKey;

    private Long suppliedAmount;

    private Long vat;
}
