package com.service.financeService.payment_employee.application.usecase.get;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.payment_employee.application.ports.input.GetPaymentEmployeeByEmployeeInputPort;
import com.service.financeService.payment_employee.application.ports.output.FindPaymentEmployeeByEmployeeIdOutputPort;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@UseCase
@Service
@RequiredArgsConstructor
public class GetPaymentEmployeeByEmployeeUseCase implements GetPaymentEmployeeByEmployeeInputPort {

    private final FindPaymentEmployeeByEmployeeIdOutputPort findByEmployeePort;

    @Override
    public List<PaymentEmployeeDomainEntity> getByEmployeeId(UUID employeeId) {
        return findByEmployeePort.findByEmployeeId(employeeId);
    }
}
