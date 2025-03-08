package com.squad04.gestao_financeira.service;

import com.squad04.gestao_financeira.dto.ReceitaMapper;
import com.squad04.gestao_financeira.dto.ReceitaRequestDto;
import com.squad04.gestao_financeira.dto.ReceitaResponseDto;
import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Receita;
import com.squad04.gestao_financeira.repository.CategoriaRepository;
import com.squad04.gestao_financeira.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final CategoriaRepository categoriaRepository;

    public ReceitaService(ReceitaRepository receitaRepository, CategoriaRepository categoriaRepository) {
        this.receitaRepository = receitaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ReceitaResponseDto> getAll() {
        return receitaRepository.findAll().stream()
                .map(ReceitaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ReceitaResponseDto getById(Long id) {
        Receita receita = receitaRepository.findById(id).orElseThrow(() -> new RuntimeException("Receita não encontrada"));
        return ReceitaMapper.toResponseDto(receita);
    }

    public ReceitaResponseDto create(ReceitaRequestDto receitaRequestDto) {
        Categoria categoria = categoriaRepository.findById(receitaRequestDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Receita receita = ReceitaMapper.toEntity(receitaRequestDto, categoria);
        Receita receitaCreated = receitaRepository.save(receita);
        return ReceitaMapper.toResponseDto(receitaCreated);
    }

    public ReceitaResponseDto update(Long id, ReceitaRequestDto receitaRequestDto) {
        Receita receita = receitaRepository.findById(id).orElseThrow(() -> new RuntimeException("Receita não encontrada"));
        Categoria categoria = categoriaRepository.findById(receitaRequestDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        ReceitaMapper.updateFromDto(receitaRequestDto, receita);
        receita.setCategoria(categoria);
        Receita receitaUpdated = receitaRepository.save(receita);
        return ReceitaMapper.toResponseDto(receitaUpdated);
    }

    public void deleteById(Long id) {
        receitaRepository.deleteById(id);
    }
}