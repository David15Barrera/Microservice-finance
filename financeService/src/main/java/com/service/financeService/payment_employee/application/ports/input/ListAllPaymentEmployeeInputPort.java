package com.service.financeService.payment_employee.application.ports.input;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;

import java.util.List;

public interface ListAllPaymentEmployeeInputPort {
    List<PaymentEmployeeDomainEntity> listAll();
}
