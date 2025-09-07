package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.BillDomainEntity;

public interface UpdateBillOutputPort {
    BillDomainEntity update(Integer id, BillDomainEntity bill);
}
