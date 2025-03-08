package com.squad04.gestao_financeira.service;

import com.squad04.gestao_financeira.dto.DespesaMapper;
import com.squad04.gestao_financeira.dto.DespesaRequestDto;
import com.squad04.gestao_financeira.dto.DespesaResponseDto;
import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Despesa;
import com.squad04.gestao_financeira.repository.CategoriaRepository;
import com.squad04.gestao_financeira.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;
    private final CategoriaRepository categoriaRepository;

    public DespesaService(DespesaRepository despesaRepository, CategoriaRepository categoriaRepository) {
        this.despesaRepository = despesaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<DespesaResponseDto> getAll() {
        return despesaRepository.findAll().stream()
                .map(DespesaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public DespesaResponseDto getById(Long id) {
        Despesa despesa = despesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
        return DespesaMapper.toResponseDto(despesa);
    }

    public DespesaResponseDto create(DespesaRequestDto despesaRequestDto) {
        Categoria categoria = categoriaRepository.findById(despesaRequestDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Despesa despesa = DespesaMapper.toEntity(despesaRequestDto, categoria);
        Despesa despesaCreated = despesaRepository.save(despesa);
        return DespesaMapper.toResponseDto(despesaCreated);
    }

    public DespesaResponseDto update(Long id, DespesaRequestDto despesaRequestDto) {
        Despesa despesa = despesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
        Categoria categoria = categoriaRepository.findById(despesaRequestDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        DespesaMapper.updateFromDto(despesaRequestDto, despesa);
        despesa.setCategoria(categoria);
        Despesa despesaUpdated = despesaRepository.save(despesa);
        return DespesaMapper.toResponseDto(despesaUpdated);
    }

    public void deleteById(Long id) {
        despesaRepository.deleteById(id);
    }
}