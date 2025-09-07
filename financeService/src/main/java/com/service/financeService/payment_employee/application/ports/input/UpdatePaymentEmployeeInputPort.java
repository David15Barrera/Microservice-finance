package com.service.financeService.payment_employee.application.ports.input;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

public interface UpdatePaymentEmployeeInputPort {
    PaymentEmployeeDomainEntity update(Integer id, PaymentEmployeeDomainEntity payment);
}
