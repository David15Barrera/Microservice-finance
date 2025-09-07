package com.service.financeService.bill.application.usecase.update;

import com.service.financeService.bill.application.ports.input.UpdateBillInputPort;
import com.service.financeService.bill.application.ports.output.UpdateBillOutputPort;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import com.service.financeService.common.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@Service
@RequiredArgsConstructor
public class UpdateBillUseCase implements UpdateBillInputPort {

    private final UpdateBillOutputPort updatePort;

    @Override
    public BillDomainEntity update(Integer id, BillDomainEntity bill) {
        return updatePort.update(id, bill);
    }
}
