package com.service.financeService.bill.application.ports.input;

import com.service.financeService.bill.domain.model.BillDomainEntity;

import java.util.List;

public interface ListAllBillInputPort {
    List<BillDomainEntity> listAll();
}
