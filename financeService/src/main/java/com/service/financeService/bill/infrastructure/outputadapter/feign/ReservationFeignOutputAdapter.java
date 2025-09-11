package com.service.financeService.bill.infrastructure.outputadapter.feign;

import com.service.financeService.bill.application.ports.output.FindReservationOutputPort;
import com.service.financeService.bill.domain.model.ReservasDomainEntity;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.ReservasResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.HotelFeign.HotelFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ReservationFeignOutputAdapter implements FindReservationOutputPort {
    private final HotelFeignClient client;

    public ReservationFeignOutputAdapter(HotelFeignClient client){
        this.client = client;
    }

    @Override
    public ReservasDomainEntity findById(UUID id){
        ReservasResponse response = client.getReservasById(id);

        ReservasDomainEntity domain = new ReservasDomainEntity();

        domain.setId(response.id);
        domain.setCustomerId(response.customerId);
        domain.setRoomId(response.roomId);
        domain.setStartDate(response.startDate);
        domain.setEndDate(response.endDate);
        domain.setState(response.state);
        domain.setPricePerDay(response.pricePerDay);
        domain.setMaintenanceCostPerDay(response.maintenanceCostPerDay);
        domain.setTotalPrice(response.totalPrice);
        domain.setDiscountPercentage(response.discountPercentage);
        domain.setPromotionId(response.promotionId);


        return domain;
    }

}
