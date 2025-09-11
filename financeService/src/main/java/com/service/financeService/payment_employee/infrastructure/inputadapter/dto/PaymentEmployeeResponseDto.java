package com.service.financeService.payment_employee.infrastructure.inputadapter.dto;

import com.service.financeService.payment_employee.infrastructure.outputadapter.feing.dto.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEmployeeResponseDto {
    private Integer id;
    private UUID employeeId;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime paymentDate;

    private CustomerResponse employee;
}
