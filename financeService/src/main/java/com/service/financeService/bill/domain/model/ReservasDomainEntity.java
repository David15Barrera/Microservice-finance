package com.service.financeService.bill.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ReservasDomainEntity {
    private UUID id;
    private UUID customerId;
    private UUID roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;
}
