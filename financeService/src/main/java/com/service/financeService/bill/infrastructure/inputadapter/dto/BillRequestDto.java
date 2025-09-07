package com.service.financeService.bill.infrastructure.inputadapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillRequestDto {
    private UUID reservationId;
    private UUID orderId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
}
