package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.BillDomainEntity;

import java.util.List;

public interface FindingAllBillOutputPort {
    List<BillDomainEntity> findAll();
}
