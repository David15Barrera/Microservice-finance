package com.service.financeService.bill.infrastructure.outputadapter.feign.Facktory;

import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.ReservasResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.HotelFeign.HotelFeignClient;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.UUID;

public class HotelFeignClientFallbackFactory implements FallbackFactory<HotelFeignClient> {

    @Override
    public HotelFeignClient create(Throwable cause){
        return new HotelFeignClient(){
            @Override
            public ReservasResponse getReservasById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                ReservasResponse fallbackResponse = new ReservasResponse();
                fallbackResponse.id = id;
                fallbackResponse.roomId= null;
                fallbackResponse.startDate = null;
                fallbackResponse.state = null;
                fallbackResponse.totalPrice = null;
                fallbackResponse.promotionId = null;
                fallbackResponse.maintenanceCostPerDay = null;
                fallbackResponse.discountPercentage = null;
                fallbackResponse.customerId = null;
                fallbackResponse.endDate = null;
                fallbackResponse.pricePerDay = null;
                return fallbackResponse;
                }

        };
    }
}
