package com.service.financeService.payment_employee.infrastructure.outputadapter.feing.fallback;

import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.Customer.CustomerFeignClient;
import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.dto.CustomerResponse;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerFeignClientFallbackFactory  implements FallbackFactory<CustomerFeignClient> {

    @Override
    public CustomerFeignClient create(Throwable cause){
        return new CustomerFeignClient() {
            @Override
            public CustomerResponse getCustomerById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                    CustomerResponse fallbackResponse = new CustomerResponse();
                    fallbackResponse.id = id;
                    fallbackResponse.fullName = "Servicio de Clientes no disponible (Error de conexión)";
                    return fallbackResponse;
                }

                System.err.println("Other error: " + cause.getMessage());
                CustomerResponse fallbackResponse = new CustomerResponse();
                fallbackResponse.id = id;
                fallbackResponse.fullName = "Servicio de Clientes no disponible (Error genérico)";
                return fallbackResponse;
            }
        };
    }

}
