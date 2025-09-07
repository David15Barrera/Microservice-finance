package com.service.financeService.bill.application.ports.input;

import com.service.financeService.bill.domain.model.BillDomainEntity;

public interface CreateBillInputPort {
    BillDomainEntity create(BillDomainEntity bill);
}
