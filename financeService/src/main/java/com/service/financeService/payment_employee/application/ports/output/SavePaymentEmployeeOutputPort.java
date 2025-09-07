package com.service.financeService.payment_employee.application.ports.output;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

public interface SavePaymentEmployeeOutputPort {
    PaymentEmployeeDomainEntity save(PaymentEmployeeDomainEntity payment);
}
