package com.service.financeService.payment_employee.infrastructure.outputadapter;

import com.service.financeService.payment_employee.application.ports.output.*;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import com.service.financeService.payment_employee.infrastructure.outputadapter.persistence.entity.PaymentEmployeeDBEntity;
import com.service.financeService.payment_employee.infrastructure.outputadapter.persistence.repository.PaymentEmployeeDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PaymentEmployeeRepositoryOutputAdapter implements SavePaymentEmployeeOutputPort,
        UpdatePaymentEmployeeOutputPort, DeletePaymentEmployeeOutputPort,
        FindPaymentEmployeeByIdOutputPort, FindingAllPaymentEmployeeOutputPort,
        FindPaymentEmployeeByEmployeeIdOutputPort, FindPaymentEmployeesByDateRangeOutputPort {

    private final PaymentEmployeeDBRepository repository;

    private PaymentEmployeeDomainEntity toDomain(PaymentEmployeeDBEntity e){
        return PaymentEmployeeDomainEntity.builder()
                .id(e.getId())
                .employeeId(e.getEmployeeId())
                .amount(e.getAmount())
                .startDate(e.getStartDate())
                .endDate(e.getEndDate())
                .paymentDate(e.getPaymentDate())
                .build();
    }

    private PaymentEmployeeDBEntity toEntity(PaymentEmployeeDomainEntity d){
        return PaymentEmployeeDBEntity.builder()
                .id(d.getId())
                .employeeId(d.getEmployeeId())
                .amount(d.getAmount())
                .startDate(d.getStartDate())
                .endDate(d.getEndDate())
                .paymentDate(d.getPaymentDate() == null ? LocalDateTime.now() : d.getPaymentDate())
                .build();
    }

    @Override
    public PaymentEmployeeDomainEntity save(PaymentEmployeeDomainEntity payment) {
        PaymentEmployeeDBEntity e = toEntity(payment);
        PaymentEmployeeDBEntity saved = repository.save(e);
        return toDomain(saved);
    }

    @Override
    public PaymentEmployeeDomainEntity update(Integer id, PaymentEmployeeDomainEntity payment) {
        PaymentEmployeeDBEntity e = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        e.setEmployeeId(payment.getEmployeeId());
        e.setAmount(payment.getAmount());
        e.setStartDate(payment.getStartDate());
        e.setEndDate(payment.getEndDate());
        e.setPaymentDate(payment.getPaymentDate());
        PaymentEmployeeDBEntity updated = repository.save(e);
        return toDomain(updated);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<PaymentEmployeeDomainEntity> findById(Integer id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<PaymentEmployeeDomainEntity> findAll() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<PaymentEmployeeDomainEntity> findByEmployeeId(java.util.UUID employeeId) {
        return repository.findByEmployeeId(employeeId).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<PaymentEmployeeDomainEntity> findByPaymentDateBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findByPaymentDateBetween(start, end).stream().map(this::toDomain).collect(Collectors.toList());
    }
}
