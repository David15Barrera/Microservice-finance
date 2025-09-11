package com.service.financeService.bill.infrastructure.inputadapter.mapper;

import com.service.financeService.bill.domain.model.BillDomainEntity;
import com.service.financeService.bill.infrastructure.inputadapter.dto.BillRequestDto;
import com.service.financeService.bill.infrastructure.inputadapter.dto.BillResponseDto;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.OrderResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.ReservasResponse;


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
        if(domain == null) return null;
        BillResponseDto r = new BillResponseDto();
        r.id = domain.getId();
        r.reservationId = domain.getReservationId();
        r.orderId = domain.getOrderId();
        r.amount = domain.getAmount();
        r.paymentDate = domain.getPaymentDate();
        r.paymentMethod = domain.getPaymentMethod();

        if(domain.getReservation() != null){
            ReservasResponse reservasResponse = new ReservasResponse();
            reservasResponse.id = domain.getReservation().getId();
            reservasResponse.customerId = domain.getReservation().getCustomerId();
            reservasResponse.roomId = domain.getReservation().getRoomId();
            reservasResponse.startDate = domain.getReservation().getStartDate();
            reservasResponse.endDate = domain.getReservation().getEndDate();
            reservasResponse.state = domain.getReservation().getState();
            reservasResponse.pricePerDay = domain.getReservation().getPricePerDay();
            reservasResponse.totalPrice = domain.getReservation().getTotalPrice();
            reservasResponse.maintenanceCostPerDay = domain.getReservation().getMaintenanceCostPerDay();
            reservasResponse.discountPercentage = domain.getReservation().getDiscountPercentage();
            reservasResponse.promotionId = domain.getReservation().getPromotionId();

            r.reservation = reservasResponse;
        }

        if (domain.getOrder() != null){
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.id = domain.getOrder().getId();
            orderResponse.customerId = domain.getOrder().getCustomerId();
            orderResponse.promotionId = domain.getOrder().getPromotionId();
            orderResponse.discountPercentage = domain.getOrder().getDiscountPercentage();
            orderResponse.totalPrice = domain.getOrder().getTotalPrice();
            orderResponse.createdAt = domain.getOrder().getCreatedAt();
            orderResponse.date = domain.getOrder().getDate();
            orderResponse.restaurantId = domain.getOrder().getRestaurantId();
            r.order = orderResponse;
        }
    return r;
    }
}
