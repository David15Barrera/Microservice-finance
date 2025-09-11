package com.service.financeService.bill.infrastructure.outputadapter.factory;

import com.service.financeService.bill.application.ports.output.FindOrderOutputPort;
import com.service.financeService.bill.application.ports.output.FindReservationOutputPort;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import com.service.financeService.bill.domain.model.OrderDomainEntity;
import com.service.financeService.bill.domain.model.ReservasDomainEntity;
import com.service.financeService.bill.infrastructure.inputadapter.dto.BillResponseDto;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.OrderResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.ReservasResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillWithRelationsFactory {
    private final FindOrderOutputPort orderOutputPort;
    private final FindReservationOutputPort reservationOutputPort;

    public BillWithRelationsFactory(
            FindOrderOutputPort orderOutputPort,
            FindReservationOutputPort reservationOutputPort) {
        this.orderOutputPort = orderOutputPort;
        this.reservationOutputPort = reservationOutputPort;
    }

    public BillResponseDto fromDomain(BillDomainEntity bill) {
        if (bill == null) return null;

        BillResponseDto dto = new BillResponseDto();
        dto.id = bill.getId();
        dto.orderId = bill.getOrderId();
        dto.reservationId = bill.getReservationId();
        dto.amount = bill.getAmount();
        dto.paymentDate = bill.getPaymentDate();
        dto.paymentMethod = bill.getPaymentMethod();

        //Responde Order
        if (bill.getOrderId() != null) {
            try {
                OrderDomainEntity order = orderOutputPort.findById(bill.getOrderId());
                if (order != null) {
                    OrderResponse o = new OrderResponse();
                    o.id = order.getId();
                    o.customerId = order.getCustomerId();
                    o.restaurantId = order.getRestaurantId();
                    o.date = order.getDate();
                    o.totalPrice = order.getTotalPrice();
                    o.discountPercentage = order.getDiscountPercentage();
                    o.promotionId = order.getPromotionId();
                    o.createdAt = order.getCreatedAt();
                    dto.order = o;
                }
            } catch (Exception e) {
                dto.order = null;
            }
        }

        //Response Reservation
        if (bill.getReservationId() != null) {
            try {
                ReservasDomainEntity reservation = reservationOutputPort.findById(bill.getReservationId());
                if (reservation != null) {
                    ReservasResponse r = new ReservasResponse();
                    r.id = reservation.getId();
                    r.customerId = reservation.getCustomerId();
                    r.roomId = reservation.getRoomId();
                    r.startDate = reservation.getStartDate();
                    r.endDate = reservation.getEndDate();
                    r.state = reservation.getState();
                    r.pricePerDay = reservation.getPricePerDay();
                    r.maintenanceCostPerDay = reservation.getMaintenanceCostPerDay();
                    r.totalPrice = reservation.getTotalPrice();
                    r.discountPercentage = reservation.getDiscountPercentage();
                    r.promotionId = reservation.getPromotionId();
                    dto.reservation = r;
                }
            } catch (Exception e) {
                dto.reservation = null;
            }
        }

        return dto;
    }

    public List<BillResponseDto> fromDomainList(List<BillDomainEntity> bills) {
        return bills.stream().map(this::fromDomain).toList();
    }
}
