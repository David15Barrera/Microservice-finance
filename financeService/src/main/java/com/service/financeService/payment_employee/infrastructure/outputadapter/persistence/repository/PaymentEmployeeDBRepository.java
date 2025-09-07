package com.service.financeService.payment_employee.infrastructure.outputadapter.persistence.repository;

import com.service.financeService.payment_employee.infrastructure.outputadapter.persistence.entity.PaymentEmployeeDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentEmployeeDBRepository extends JpaRepository<PaymentEmployeeDBEntity, Integer> {
    List<PaymentEmployeeDBEntity> findByEmployeeId(UUID employeeId);
    List<PaymentEmployeeDBEntity> findByPaymentDateBetween(LocalDateTime start, LocalDateTime end);
}
