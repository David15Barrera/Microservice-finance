package com.service.financeService.payment_employee.application.usecase.listpayment;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.payment_employee.application.ports.input.ListAllPaymentEmployeeInputPort;
import com.service.financeService.payment_employee.application.ports.output.FindingAllPaymentEmployeeOutputPort;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
@RequiredArgsConstructor
public class ListAllPaymentEmployeUseCase implements ListAllPaymentEmployeeInputPort {

    private final FindingAllPaymentEmployeeOutputPort findingAllPaymentEmployeeOutputPort;

    @Override
    public List<PaymentEmployeeDomainEntity> listAll(){
        return findingAllPaymentEmployeeOutputPort.findAll();
    }
}
