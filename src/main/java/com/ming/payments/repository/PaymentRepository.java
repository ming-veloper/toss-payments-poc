package com.ming.payments.repository;

import com.ming.payments.entity.Payment;
import com.ming.payments.entity.value.PaymentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentKey> {
}
