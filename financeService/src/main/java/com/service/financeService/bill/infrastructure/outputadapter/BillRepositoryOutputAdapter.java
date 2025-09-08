package com.service.financeService.bill.infrastructure.outputadapter;

import com.service.financeService.bill.application.ports.output.*;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import com.service.financeService.bill.infrastructure.outputadapter.persistence.entity.BillDBEntity;
import com.service.financeService.bill.infrastructure.outputadapter.persistence.repository.BillDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BillRepositoryOutputAdapter implements SaveBillOutputPort, UpdateBillOutputPort,
        DeleteBillOutputPort, FindBillByIdOutputPort, FindingAllBillOutputPort,
        FindBillsByDateRangeOutputPort{

    private final BillDBRepository repository;

    private BillDomainEntity toDomain(BillDBEntity e){
        return BillDomainEntity.builder()
                .id(e.getId())
                .reservationId(e.getReservationId())
                .orderId(e.getOrderId())
                .amount(e.getAmount())
                .paymentDate(e.getPaymentDate())
                .paymentMethod(e.getPaymentMethod())
                .build();
    }

    private BillDBEntity toEntity(BillDomainEntity d){
        return BillDBEntity.builder()
                .id(d.getId())
                .reservationId(d.getReservationId())
                .orderId(d.getOrderId())
                .amount(d.getAmount())
                .paymentDate(d.getPaymentDate() == null ? LocalDateTime.now() : d.getPaymentDate())
                .paymentMethod(d.getPaymentMethod())
                .build();
    }

    @Override
    public BillDomainEntity save(BillDomainEntity bill) {
        BillDBEntity e = toEntity(bill);
        BillDBEntity saved = repository.save(e);
        return toDomain(saved);
    }

    @Override
    public BillDomainEntity update(Integer id, BillDomainEntity bill) {
        BillDBEntity e = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        e.setReservationId(bill.getReservationId());
        e.setOrderId(bill.getOrderId());
        e.setAmount(bill.getAmount());
        e.setPaymentDate(bill.getPaymentDate());
        e.setPaymentMethod(bill.getPaymentMethod());
        BillDBEntity updated = repository.save(e);
        return toDomain(updated);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<BillDomainEntity> findById(Integer id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<BillDomainEntity> findAll() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<BillDomainEntity> findByPaymentDateBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findByPaymentDateBetween(start, end)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
