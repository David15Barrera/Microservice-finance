package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.BillDomainEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface FindBillsByDateRangeOutputPort {
    List<BillDomainEntity> findByPaymentDateBetween(LocalDateTime start, LocalDateTime end);
}
