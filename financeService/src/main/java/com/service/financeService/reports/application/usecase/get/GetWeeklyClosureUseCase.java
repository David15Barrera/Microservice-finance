package com.service.financeService.reports.application.usecase.get;

import com.service.financeService.common.annotations.UseCase;
import com.service.financeService.bill.application.ports.output.FindBillsByDateRangeOutputPort;
import com.service.financeService.payment_employee.application.ports.output.FindPaymentEmployeesByDateRangeOutputPort;
import com.service.financeService.reports.application.ports.input.GetWeeklyClosureInputPort;
import com.service.financeService.reports.domain.model.WeeklyClosureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@UseCase
@Service
@RequiredArgsConstructor
public class GetWeeklyClosureUseCase implements GetWeeklyClosureInputPort {

    private final FindBillsByDateRangeOutputPort billsByDatePort;
    private final FindPaymentEmployeesByDateRangeOutputPort paymentsByDatePort;

    @Override
    public WeeklyClosureDto getWeeklyClosure(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23,59,59);

        List<com.service.financeService.bill.domain.model.BillDomainEntity> bills = billsByDatePort.findByPaymentDateBetween(start, end);
        List<com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity> payments = paymentsByDatePort.findByPaymentDateBetween(start, end);

        // Usa BigDecimal para las sumas
        BigDecimal totalIncome = bills.stream()
                .map(b -> b.getAmount() == null ? BigDecimal.ZERO : b.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Suma los BigDecimal

        BigDecimal totalExpenses = payments.stream()
                .map(p -> p.getAmount() == null ? BigDecimal.ZERO : p.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Suma los BigDecimal

        BigDecimal net = totalIncome.subtract(totalExpenses);

        return WeeklyClosureDto.builder()
                .startDate(startDate)
                .endDate(endDate)
                .totalIncome(totalIncome)
                .totalExpenses(totalExpenses)
                .net(net)
                .build();
    }
}
