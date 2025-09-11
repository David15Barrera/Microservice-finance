package com.service.financeService.bill.infrastructure.inputadapter.dto;

import com.service.financeService.bill.domain.model.PaymentMethodEnum;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.OrderResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.ReservasResponse;
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
public class BillResponseDto {
    public Integer id;
    public UUID reservationId;
    public UUID orderId;
    public BigDecimal amount;
    public LocalDateTime paymentDate;
    public PaymentMethodEnum paymentMethod;

    public OrderResponse order;
    public ReservasResponse reservation;
}
