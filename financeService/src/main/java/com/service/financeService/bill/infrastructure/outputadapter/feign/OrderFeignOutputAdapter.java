package com.service.financeService.bill.infrastructure.outputadapter.feign;

import com.service.financeService.bill.application.ports.output.FindOrderOutputPort;
import com.service.financeService.bill.domain.model.OrderDomainEntity;
import com.service.financeService.bill.infrastructure.outputadapter.feign.dto.OrderResponse;
import com.service.financeService.bill.infrastructure.outputadapter.feign.RestaurantFeign.RestaurantFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderFeignOutputAdapter implements FindOrderOutputPort {

    private final RestaurantFeignClient client;

    public OrderFeignOutputAdapter(RestaurantFeignClient client){
        this.client = client;
    }

    @Override
    public OrderDomainEntity findById(UUID id){
        OrderResponse response = client.getOrderById(id);

        OrderDomainEntity domain = new OrderDomainEntity();
        domain.setId(response.id);
        domain.setCustomerId(response.customerId);
        domain.setRestaurantId(response.restaurantId);
        domain.setDate(response.date);
        domain.setTotalPrice(response.totalPrice);
        domain.setDiscountPercentage(response.discountPercentage);
        domain.setPromotionId(response.promotionId);
        domain.setCreatedAt(response.createdAt);

        return domain;
    }
}
