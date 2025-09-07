package com.service.financeService.payment_employee.application.ports.output;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

import java.util.Optional;

public interface FindPaymentEmployeeByIdOutputPort {
    Optional<PaymentEmployeeDomainEntity> findById(Integer id);
}
