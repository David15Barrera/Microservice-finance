package com.service.financeService.payment_employee.application.ports.output;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

import java.util.List;

public interface FindingAllPaymentEmployeeOutputPort {
    List<PaymentEmployeeDomainEntity> findAll();
}
