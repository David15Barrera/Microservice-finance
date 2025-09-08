package com.service.financeService.reports.application.ports.input;

import com.service.financeService.reports.domain.model.WeeklyClosureDto;

import java.time.LocalDate;

public interface GetWeeklyClosureInputPort {
    WeeklyClosureDto getWeeklyClosure(LocalDate startDate, LocalDate endDate);
}
