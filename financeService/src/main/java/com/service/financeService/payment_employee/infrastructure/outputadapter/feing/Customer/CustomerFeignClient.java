package com.service.financeService.payment_employee.infrastructure.outputadapter.feing.Customer;

import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.dto.CustomerResponse;
import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.fallback.CustomerFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "customerClient", url = "https://microservice-authemploye.onrender.com/api/auth-identity", fallbackFactory = CustomerFeignClientFallbackFactory.class)
public interface CustomerFeignClient {
    @GetMapping("/v1/employees/{id}")
    CustomerResponse getCustomerById(@PathVariable("id") UUID id);
}
