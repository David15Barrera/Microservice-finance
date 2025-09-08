package com.service.financeService.reports.infrastructure.inputadapter.rest;

import com.service.financeService.reports.application.ports.input.GetWeeklyClosureInputPort;
import com.service.financeService.reports.domain.model.WeeklyClosureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportsControllerAdapter {

    private final GetWeeklyClosureInputPort getWeeklyClosureUseCase;

    @GetMapping("/weekly-closure")
    public ResponseEntity<WeeklyClosureDto> weeklyClosure(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        WeeklyClosureDto dto = getWeeklyClosureUseCase.getWeeklyClosure(startDate, endDate);
        return ResponseEntity.ok(dto);
    }
}
