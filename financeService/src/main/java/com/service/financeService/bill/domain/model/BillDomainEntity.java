package com.service.financeService.bill.domain.model;

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
public class BillDomainEntity {
    private Integer id;
    private UUID reservationId;
    private UUID orderId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private PaymentMethodEnum paymentMethod;

    private OrderDomainEntity order;
    private ReservasDomainEntity reservation;
}
