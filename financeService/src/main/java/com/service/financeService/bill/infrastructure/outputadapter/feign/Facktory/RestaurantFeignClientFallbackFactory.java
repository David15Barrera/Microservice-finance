package com.service.financeService.bill.infrastructure.outputadapter.feign.Facktory;

import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.OrderResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.RestaurantFeign.RestaurantFeignClient;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.UUID;

public class RestaurantFeignClientFallbackFactory implements FallbackFactory<RestaurantFeignClient> {

    @Override
    public RestaurantFeignClient create(Throwable cause){
        return new RestaurantFeignClient() {
            @Override
            public OrderResponse getOrderById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                OrderResponse fallbackResponse = new OrderResponse();
                fallbackResponse.id = id;
                fallbackResponse.restaurantId= null;
                fallbackResponse.totalPrice = null;
                fallbackResponse.date = null;
                fallbackResponse.discountPercentage = null;
                fallbackResponse.customerId = null;
                fallbackResponse.createdAt = null;
                fallbackResponse.promotionId = null;
                return fallbackResponse;
            }
        };
    }
}
