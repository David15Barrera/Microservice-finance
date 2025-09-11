package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.OrderDomainEntity;

import java.util.UUID;

public interface FindOrderOutputPort {
    OrderDomainEntity findById(UUID id);
}
