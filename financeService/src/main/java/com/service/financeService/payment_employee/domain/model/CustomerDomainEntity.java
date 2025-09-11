package com.service.financeService.payment_employee.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CustomerDomainEntity {

    private UUID id;
    private String fullName;
    private String cui;
    private String phone;
    private String email;
    private String jobPosition;
    private BigDecimal salary;
    private String address;

}
