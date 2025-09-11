package com.service.financeService.bill.infrastructure.outputadapter.feign.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class OrderResponse {
    public UUID id;
    public UUID customerId;
    public UUID restaurantId;
    public OffsetDateTime date;
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
    public OffsetDateTime createdAt;
}
