package com.service.financeService.payment_employee.application.ports.input;

import com.service.financeService.payment_employee.domain.model.CustomerDomainEntity;

import java.util.UUID;

public interface FindCustomerOutputPort {
    CustomerDomainEntity findById(UUID id);
}
