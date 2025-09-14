package com.service.financeService.bill.infrastructure.outputadapter.feign.HotelFeign;

import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.ReservasResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.Facktory.HotelFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "hotelClient", url = "https://microservice-hotel.onrender.com/api/hotel", fallbackFactory = HotelFeignClientFallbackFactory.class)
public interface HotelFeignClient {
    @GetMapping("/api/v1/reservations/{id}")
    ReservasResponse getReservasById(@PathVariable("id") UUID id);
}
