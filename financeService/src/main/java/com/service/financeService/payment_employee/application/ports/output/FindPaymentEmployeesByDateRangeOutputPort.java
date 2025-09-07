package com.service.financeService.payment_employee.application.ports.output;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface FindPaymentEmployeesByDateRangeOutputPort {
    List<PaymentEmployeeDomainEntity> findByPaymentDateBetween(LocalDateTime start, LocalDateTime end);
}
