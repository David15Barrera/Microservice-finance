package com.service.financeService.payment_employee.application.ports.input;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

public interface CreatePaymentEmployeeInputPort {
    PaymentEmployeeDomainEntity create(PaymentEmployeeDomainEntity payment);
}
