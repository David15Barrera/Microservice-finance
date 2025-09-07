package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.BillDomainEntity;

public interface SaveBillOutputPort {
    BillDomainEntity save(BillDomainEntity bill);
}
