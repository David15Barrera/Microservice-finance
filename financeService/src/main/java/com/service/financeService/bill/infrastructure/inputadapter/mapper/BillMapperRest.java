package com.service.financeService.bill.infrastructure.inputadapter.mapper;

import com.service.financeService.bill.domain.model.BillDomainEntity;
import com.service.financeService.bill.infrastructure.inputadapter.dto.*;

public class BillMapperRest {
    public static BillDomainEntity toDomain(BillRequestDto dto){
        return BillDomainEntity.builder()
                .reservationId(dto.getReservationId())
                .orderId(dto.getOrderId())
                .amount(dto.getAmount())
                .paymentDate(dto.getPaymentDate())
                .paymentMethod(dto.getPaymentMethod())
                .build();
    }

    public static BillResponseDto toResponse(BillDomainEntity domain){
        return BillResponseDto.builder()
                .id(domain.getId())
                .reservationId(domain.getReservationId())
                .orderId(domain.getOrderId())
                .amount(domain.getAmount())
                .paymentDate(domain.getPaymentDate())
                .paymentMethod(domain.getPaymentMethod())
                .build();
    }
}
