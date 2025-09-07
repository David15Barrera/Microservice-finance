package com.service.financeService.payment_employee.application.ports.output;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

public interface UpdatePaymentEmployeeOutputPort {
    PaymentEmployeeDomainEntity update(Integer id, PaymentEmployeeDomainEntity payment);
}
