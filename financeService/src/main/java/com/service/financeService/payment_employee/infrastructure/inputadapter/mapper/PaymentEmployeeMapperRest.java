package com.service.financeService.payment_employee.infrastructure.inputadapter.mapper;

import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import com.service.financeService.payment_employee.infrastructure.inputadapter.dto.PaymentEmployeeRequestDto;
import com.service.financeService.payment_employee.infrastructure.inputadapter.dto.PaymentEmployeeResponseDto;

public class PaymentEmployeeMapperRest {

        public static PaymentEmployeeDomainEntity toDomain(PaymentEmployeeResponseDto dto){
            return PaymentEmployeeDomainEntity.builder()
                    .id(dto.getId())
                    .employeeId(dto.getEmployeeId())
                    .amount(dto.getAmount())
                    .startDate(dto.getStartDate())
                    .endDate(dto.getEndDate())
                    .paymentDate(dto.getPaymentDate())
                    .build();
        }

        public static PaymentEmployeeDomainEntity toDomain(PaymentEmployeeRequestDto dto){
            return PaymentEmployeeDomainEntity.builder()
                    .employeeId(dto.getEmployeeId())
                    .amount(dto.getAmount())
                    .startDate(dto.getStartDate())
                    .endDate(dto.getEndDate())
                    .paymentDate(dto.getPaymentDate())
                    .build();
        }

        public static PaymentEmployeeResponseDto toResponse(PaymentEmployeeDomainEntity domain){
            return PaymentEmployeeResponseDto.builder()
                    .id(domain.getId())
                    .employeeId(domain.getEmployeeId())
                    .amount(domain.getAmount())
                    .endDate(domain.getEndDate())
                    .paymentDate(domain.getPaymentDate())
                    .build();
        }
}

