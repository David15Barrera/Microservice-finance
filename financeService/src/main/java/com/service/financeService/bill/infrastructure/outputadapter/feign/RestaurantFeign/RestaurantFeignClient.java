package com.service.financeService.bill.infrastructure.outputadapter.feign.RestaurantFeign;

import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.OrderResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.Facktory.RestaurantFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "RestaurantClient", url = "https://microservice-restaurante-1.onrender.com/api/restaurant", fallbackFactory = RestaurantFeignClientFallbackFactory.class)
public interface RestaurantFeignClient {
    @GetMapping("/api/orders/{id}")
    OrderResponse getOrderById(@PathVariable("id") UUID id);

}
