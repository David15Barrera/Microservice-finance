package com.service.financeService.payment_employee.infrastructure.inputadapter.rest;

import com.service.financeService.payment_employee.application.ports.input.*;
import com.service.financeService.payment_employee.domain.model.PaymentEmployeeDomainEntity;
import com.service.financeService.payment_employee.infrastructure.inputadapter.dto.*;
import com.service.financeService.payment_employee.infrastructure.inputadapter.mapper.PaymentEmployeeMapperRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payment-employees")
@RequiredArgsConstructor
public class PaymentEmployeeControllerAdapter {

    private final CreatePaymentEmployeeInputPort createUseCase;
    private final UpdatePaymentEmployeeInputPort updateUseCase;
    private final GetPaymentEmployeeByIdInputPort getUseCase;
    private final DeletePaymentEmployeeInputPort deleteUseCase;
    private final ListAllPaymentEmployeeInputPort listUseCase;
    private final GetPaymentEmployeeByEmployeeInputPort getByEmployeeUseCase;

    @PostMapping
    public ResponseEntity<PaymentEmployeeResponseDto> create(@RequestBody PaymentEmployeeRequestDto dto){
        PaymentEmployeeDomainEntity domain = PaymentEmployeeMapperRest.toDomain(dto);
        PaymentEmployeeDomainEntity created = createUseCase.create(domain);
        return ResponseEntity.ok(PaymentEmployeeMapperRest.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentEmployeeResponseDto> get(@PathVariable Integer id){
        PaymentEmployeeDomainEntity found = getUseCase.getById(id);
        return ResponseEntity.ok(PaymentEmployeeMapperRest.toResponse(found));
    }

    @GetMapping
    public ResponseEntity<List<PaymentEmployeeResponseDto>> listAll(){
        var list = listUseCase.listAll();
        var resp = list.stream().map(PaymentEmployeeMapperRest::toResponse).toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<PaymentEmployeeResponseDto>> getByEmployee(@PathVariable UUID employeeId){
        var list = getByEmployeeUseCase.getByEmployeeId(employeeId);
        var resp = list.stream().map(PaymentEmployeeMapperRest::toResponse).toList();
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentEmployeeResponseDto> update(@PathVariable Integer id, @RequestBody PaymentEmployeeRequestDto dto){
        var domain = PaymentEmployeeMapperRest.toDomain(dto);
        var updated = updateUseCase.update(id, domain);
        return ResponseEntity.ok(PaymentEmployeeMapperRest.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        deleteUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
