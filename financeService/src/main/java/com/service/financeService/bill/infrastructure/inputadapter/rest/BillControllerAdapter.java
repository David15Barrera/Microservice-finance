package com.service.financeService.bill.infrastructure.inputadapter.rest;

import com.service.financeService.bill.application.ports.input.*;
import com.service.financeService.bill.domain.model.BillDomainEntity;
import com.service.financeService.bill.infrastructure.inputadapter.dto.*;
import com.service.financeService.bill.infrastructure.inputadapter.mapper.BillMapperRest;
import com.service.financeService.bill.infrastructure.outputadapter.factory.BillWithRelationsFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
public class BillControllerAdapter {

    private final CreateBillInputPort createUseCase;
    private final UpdateBillInputPort updateUseCase;
    private final GetBillByIdInputPort getUseCase;
    private final DeleteBillInputPort deleteUseCase;
    private final ListAllBillInputPort listUseCase;
    private final BillWithRelationsFactory billFactory;

    @PostMapping
    public ResponseEntity<BillResponseDto> create(@RequestBody BillRequestDto dto){
        BillDomainEntity domain = BillMapperRest.toDomain(dto);
        BillDomainEntity created = createUseCase.create(domain);
        return ResponseEntity.ok(billFactory.fromDomain(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillResponseDto> get(@PathVariable Integer id){
        BillDomainEntity found = getUseCase.getById(id);
        return ResponseEntity.ok(billFactory.fromDomain(found));
    }

    @GetMapping
    public ResponseEntity<List<BillResponseDto>> listAll(){
        List<BillDomainEntity> bills = listUseCase.listAll();
        List<BillResponseDto> resp = billFactory.fromDomainList(bills);
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillResponseDto> update(@PathVariable Integer id, @RequestBody BillRequestDto dto){
        BillDomainEntity domain = BillMapperRest.toDomain(dto);
        BillDomainEntity updated = updateUseCase.update(id, domain);
        return ResponseEntity.ok(billFactory.fromDomain(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        deleteUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
