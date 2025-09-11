package com.service.financeService.payment_employee.infrastructure.outputadapter.feing;

import com.service.financeService.payment_employee.application.ports.input.FindCustomerOutputPort;
import com.service.financeService.payment_employee.domain.model.CustomerDomainEntity;
import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.Customer.CustomerFeignClient;
import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.dto.CustomerResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerFeignOutputAdapter implements FindCustomerOutputPort {
    private final CustomerFeignClient client;

    public CustomerFeignOutputAdapter(CustomerFeignClient client) {
        this.client = client;
    }

    @Override
    public CustomerDomainEntity findById(UUID id) {
        CustomerResponse response = client.getCustomerById(UUID.fromString(id.toString()));

        if (response == null) {
            return null;
        }

        CustomerDomainEntity domain = new CustomerDomainEntity();

        domain.setId(UUID.fromString(String.valueOf(response.id)));
        domain.setFullName(response.fullName);
        domain.setCui(response.cui);
        domain.setPhone(response.phone);
        domain.setEmail(response.email);
        domain.setAddress(response.address);
        return domain;
    }
}
