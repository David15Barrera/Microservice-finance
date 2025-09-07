package com.service.financeService.bill.application.usecase.delete;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.bill.application.ports.input.DeleteBillInputPort;
import com.service.financeService.bill.application.ports.output.DeleteBillOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@Service
@RequiredArgsConstructor
public class DeleteBillUseCase implements DeleteBillInputPort {

    private final DeleteBillOutputPort deletePort;

    @Override
    public void delete(Integer id) {
        deletePort.delete(id);
    }
}
