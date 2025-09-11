package com.service.financeService.bill.infrastructure.outputadapter.feign.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ReservasResponse {
    public UUID id;
    public UUID customerId;
    public UUID roomId;
    public LocalDate startDate;
    public LocalDate endDate;
    public String state;
    public BigDecimal pricePerDay;
    public BigDecimal maintenanceCostPerDay;
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}
