package com.service.financeService.bill.application.usecase.listhotels;

import com.service.financeService.bill.application.ports.output.FindOrderOutputPort;
import com.service.financeService.bill.application.ports.output.FindReservationOutputPort;
import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.bill.application.ports.input.ListAllBillInputPort;
import com.service.financeService.bill.application.ports.output.FindingAllBillOutputPort;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
@RequiredArgsConstructor
public class ListAllBillUseCase implements ListAllBillInputPort {

    private final FindingAllBillOutputPort findingAllPort;
    private final FindOrderOutputPort findOrderOutputPort;
    private final FindReservationOutputPort findReservationOutputPort;

    @Override
    public List<BillDomainEntity> listAll() {
        List<BillDomainEntity> bills = findingAllPort.findAll();

     return bills;
    }
}
