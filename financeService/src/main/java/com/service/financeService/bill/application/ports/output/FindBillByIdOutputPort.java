package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.BillDomainEntity;

import java.util.Optional;

public interface FindBillByIdOutputPort {
    Optional<BillDomainEntity> findById(Integer id);
}
