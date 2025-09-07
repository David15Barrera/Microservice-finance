package com.service.financeService.payment_employee.application.usecase.get;

import com.service.financeService.payment_employee.application.ports.input.GetPaymentEmployeeByIdInputPort;
import com.service.financeService.payment_employee.application.ports.output.FindPaymentEmployeeByIdOutputPort;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPaymentEmployeeByIdUseCase implements GetPaymentEmployeeByIdInputPort {


    private final FindPaymentEmployeeByIdOutputPort findPaymentEmployeeByIdOutputPort;

    @Override
    public PaymentEmployeeDomainEntity getById(Integer id) {
        return findPaymentEmployeeByIdOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found for id: " + id));
    }
}
