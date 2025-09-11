package com.service.financeService.payment_employee.infrastructure.outputadapter.factory;

import com.service.financeService.bill.domain.model.OrderDomainEntity;
import com.service.financeService.payment_employee.application.ports.input.FindCustomerOutputPort;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import com.service.financeService.payment_employee.infrastructure.inputadapter.dto.PaymentEmployeeResponseDto;
import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.Customer.CustomerFeignClient;
import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PaymentEmployeeFactory {
    private final CustomerFeignClient customerFeignClient;

    public PaymentEmployeeResponseDto fromDomain(PaymentEmployeeDomainEntity domain) {
        CustomerResponse employee = null;
        if (domain.getEmployeeId() != null) {
            employee = customerFeignClient.getCustomerById(UUID.fromString(domain.getEmployeeId().toString()));
        }

        return PaymentEmployeeResponseDto.builder()
                .id(domain.getId())
                .employeeId(domain.getEmployeeId())
                .amount(domain.getAmount())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .paymentDate(domain.getPaymentDate())
                .employee(employee)
                .build();
    }
}
