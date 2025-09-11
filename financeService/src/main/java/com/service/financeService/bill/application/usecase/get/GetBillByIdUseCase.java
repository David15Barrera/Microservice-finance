package com.service.financeService.bill.application.usecase.get;

import com.service.financeService.bill.application.ports.output.FindOrderOutputPort;
import com.service.financeService.bill.application.ports.output.FindReservationOutputPort;
import com.service.financeService.bill.domain.model.OrderDomainEntity;
import com.service.financeService.bill.domain.model.ReservasDomainEntity;
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
    private final FindOrderOutputPort findOrderOutputPort;
    private final FindReservationOutputPort findReservationOutputPort;

    @Override
    public BillDomainEntity getById(Integer id) {
        BillDomainEntity bill = findByIdPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found" + id));

        return bill;
    }
}
