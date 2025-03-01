package com.squad04.gestao_financeira.controller;

import com.squad04.gestao_financeira.dto.TransacaoRequestDto;
import com.squad04.gestao_financeira.dto.TransacaoResponseDto;
import com.squad04.gestao_financeira.model.Transacao;
import com.squad04.gestao_financeira.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {

    private TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getTransacoes() {
        return ResponseEntity.ok(transacaoService.getAll());

    }

    @GetMapping("/categoria/{categoryId}")
    public ResponseEntity<List<TransacaoResponseDto>> getTransacaoByCategoria(@PathVariable Long categoryId ) {
        return ResponseEntity.ok(transacaoService.getByCategoria(categoryId));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoResponseDto> getTransacaoById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.getById(id));

    }
    @PostMapping
    public ResponseEntity<TransacaoResponseDto> createTransacao(@RequestBody TransacaoRequestDto transacaoRequestDto) {
        TransacaoResponseDto transacaoCreated = transacaoService.create(transacaoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoCreated);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TransacaoResponseDto> updateTransacao(@PathVariable Long id, @RequestBody TransacaoRequestDto transacaoRequestDto) {
       TransacaoResponseDto transacaoUpdated = transacaoService.update(id, transacaoRequestDto);
        return ResponseEntity.ok(transacaoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        transacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
