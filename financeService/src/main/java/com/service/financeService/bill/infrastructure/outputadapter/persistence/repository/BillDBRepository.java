package com.service.financeService.bill.infrastructure.outputadapter.persistence.repository;

import com.service.financeService.bill.infrastructure.outputadapter.persistence.entity.BillDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BillDBRepository extends JpaRepository<BillDBEntity, Integer> {
    List<BillDBEntity> findByPaymentDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
