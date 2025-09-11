package com.service.financeService.bill.application.ports.output;

import com.service.financeService.bill.domain.model.ReservasDomainEntity;

import java.util.UUID;

public interface FindReservationOutputPort {
    ReservasDomainEntity findById(UUID id);
}
