package com.service.financeService.payment_employee.infrastructure.outputadapter.feing.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class CustomerResponse {
    public UUID id;
    public String fullName;
    public String cui;
    public String phone;
    public String email;
    public String jobPosition;
    public BigDecimal salary;
    public String address;
}
