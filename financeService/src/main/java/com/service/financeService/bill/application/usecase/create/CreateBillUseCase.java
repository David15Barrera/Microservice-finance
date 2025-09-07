package com.service.financeService.bill.application.usecase.create;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.bill.application.ports.input.CreateBillInputPort;
import com.service.financeService.bill.application.ports.output.SaveBillOutputPort;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@Service
@RequiredArgsConstructor
public class CreateBillUseCase implements CreateBillInputPort {

    private final SaveBillOutputPort savePort;

    @Override
    public BillDomainEntity create(BillDomainEntity bill) {
        return savePort.save(bill);
    }
}
