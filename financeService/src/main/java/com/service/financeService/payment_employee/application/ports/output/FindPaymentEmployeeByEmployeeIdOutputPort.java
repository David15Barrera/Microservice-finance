package com.service.financeService.payment_employee.application.ports.output;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindPaymentEmployeeByEmployeeIdOutputPort {
    List<PaymentEmployeeDomainEntity> findByEmployeeId(UUID employeeId);
}
