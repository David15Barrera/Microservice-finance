package com.service.financeService.payment_employee.application.ports.factory;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

public class PaymentEmployeeFactory {
    public static PaymentEmployeeDomainEntity createDefault() {
        return PaymentEmployeeDomainEntity.builder().build();
    }
}
