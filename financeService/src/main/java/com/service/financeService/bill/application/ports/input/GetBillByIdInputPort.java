package com.service.financeService.bill.application.ports.input;

import com.service.financeService.bill.domain.model.BillDomainEntity;

public interface GetBillByIdInputPort {
    BillDomainEntity getById(Integer id);
}
