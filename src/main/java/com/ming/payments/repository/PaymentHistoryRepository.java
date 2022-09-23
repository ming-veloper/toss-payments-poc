package com.ming.payments.repository;

import com.ming.payments.domain.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, String> {
}
