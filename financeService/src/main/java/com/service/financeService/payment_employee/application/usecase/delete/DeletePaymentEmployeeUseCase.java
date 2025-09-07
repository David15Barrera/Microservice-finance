package com.service.financeService.payment_employee.application.usecase.delete;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.payment_employee.application.ports.input.DeletePaymentEmployeeInputPort;
import com.service.financeService.payment_employee.application.ports.output.DeletePaymentEmployeeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@Service
@RequiredArgsConstructor
public class DeletePaymentEmployeeUseCase implements DeletePaymentEmployeeInputPort {

    private final DeletePaymentEmployeeOutputPort deleteport;

    @Override
    public void delete(Integer id){
        deleteport.delete(id);
    }
}
