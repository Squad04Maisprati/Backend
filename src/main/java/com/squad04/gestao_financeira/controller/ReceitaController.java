package com.squad04.gestao_financeira.controller;

import com.squad04.gestao_financeira.dto.ReceitaRequestDto;
import com.squad04.gestao_financeira.dto.ReceitaResponseDto;
import com.squad04.gestao_financeira.service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public ResponseEntity<List<ReceitaResponseDto>> getReceitas() {
        return ResponseEntity.ok(receitaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaResponseDto> getReceitaById(@PathVariable Long id) {
        return ResponseEntity.ok(receitaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ReceitaResponseDto> createReceita(@RequestBody ReceitaRequestDto receitaRequestDto) {
        ReceitaResponseDto receitaCreated = receitaService.create(receitaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaResponseDto> updateReceita(@PathVariable Long id, @RequestBody ReceitaRequestDto receitaRequestDto) {
        ReceitaResponseDto receitaUpdated = receitaService.update(id, receitaRequestDto);
        return ResponseEntity.ok(receitaUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable Long id) {
        receitaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}