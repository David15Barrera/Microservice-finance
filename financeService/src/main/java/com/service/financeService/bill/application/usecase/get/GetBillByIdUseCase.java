package com.service.financeService.bill.application.usecase.get;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.bill.application.ports.input.GetBillByIdInputPort;
import com.service.financeService.bill.application.ports.output.FindBillByIdOutputPort;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@UseCase
@Service
@RequiredArgsConstructor
public class GetBillByIdUseCase implements GetBillByIdInputPort {

    private final FindBillByIdOutputPort findByIdPort;

    @Override
    public BillDomainEntity getById(Integer id) {
        Optional<BillDomainEntity> opt = findByIdPort.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("Bill not found"));
    }
}
