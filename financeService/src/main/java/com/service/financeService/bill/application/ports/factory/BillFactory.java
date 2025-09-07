package com.service.financeService.bill.application.ports.factory;

import com.service.financeService.bill.domain.model.BillDomainEntity;

public class BillFactory {
    public static BillDomainEntity createDefault() {
        return BillDomainEntity.builder().build();
    }
}
