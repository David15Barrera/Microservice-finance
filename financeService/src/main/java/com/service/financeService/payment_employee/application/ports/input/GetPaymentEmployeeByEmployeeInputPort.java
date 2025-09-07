package com.service.financeService.payment_employee.application.ports.input;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

import java.util.List;
import java.util.UUID;

public interface GetPaymentEmployeeByEmployeeInputPort {
    List<PaymentEmployeeDomainEntity> getByEmployeeId(UUID employeeId);
}
