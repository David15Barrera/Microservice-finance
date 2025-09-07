package com.service.financeService.payment_employee.application.usecase.create;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.payment_employee.application.ports.input.CreatePaymentEmployeeInputPort;
import com.service.financeService.payment_employee.application.ports.output.SavePaymentEmployeeOutputPort;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@Service
@RequiredArgsConstructor
public class CreatePaymentEmployeeUseCase implements CreatePaymentEmployeeInputPort {

    private final SavePaymentEmployeeOutputPort savePort;

    @Override
    public PaymentEmployeeDomainEntity create(PaymentEmployeeDomainEntity payment) {
        return savePort.save(payment);
    }
}
