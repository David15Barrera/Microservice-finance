package com.service.financeService.payment_employee.application.usecase.update;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.payment_employee.application.ports.input.UpdatePaymentEmployeeInputPort;
import com.service.financeService.payment_employee.application.ports.output.UpdatePaymentEmployeeOutputPort;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@UseCase
@Service
@RequiredArgsConstructor
public class UpdatePaymentEmployeeByEmployeeUseCase implements UpdatePaymentEmployeeInputPort {

    private final UpdatePaymentEmployeeOutputPort updatePaymentEmployeeOutputPort;

    @Override
    public PaymentEmployeeDomainEntity update(Integer id, PaymentEmployeeDomainEntity payment){
        return updatePaymentEmployeeOutputPort.update(id, payment);
    }
}
