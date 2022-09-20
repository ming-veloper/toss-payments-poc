package com.ming.payments.repository;

import com.ming.payments.domain.entity.Payment;
import com.ming.payments.domain.value.PaymentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentKey> {
}
