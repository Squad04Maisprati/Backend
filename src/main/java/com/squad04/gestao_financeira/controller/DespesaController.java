package com.squad04.gestao_financeira.controller;

import com.squad04.gestao_financeira.dto.DespesaRequestDto;
import com.squad04.gestao_financeira.dto.DespesaResponseDto;
import com.squad04.gestao_financeira.service.DespesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("despesas")
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping
    public ResponseEntity<List<DespesaResponseDto>> getDespesas() {
        return ResponseEntity.ok(despesaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaResponseDto> getDespesaById(@PathVariable Long id) {
        return ResponseEntity.ok(despesaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DespesaResponseDto> createDespesa(@RequestBody DespesaRequestDto despesaRequestDto) {
        DespesaResponseDto despesaCreated = despesaService.create(despesaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaResponseDto> updateDespesa(@PathVariable Long id, @RequestBody DespesaRequestDto despesaRequestDto) {
        DespesaResponseDto despesaUpdated = despesaService.update(id, despesaRequestDto);
        return ResponseEntity.ok(despesaUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespesa(@PathVariable Long id) {
        despesaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}