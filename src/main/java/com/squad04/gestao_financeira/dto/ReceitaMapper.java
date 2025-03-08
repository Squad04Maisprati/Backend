package com.squad04.gestao_financeira.dto;

import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Receita;

public class ReceitaMapper {

    public static ReceitaResponseDto toResponseDto(Receita receita) {
        return ReceitaResponseDto.builder()
                .valor(receita.getValor())
                .data(receita.getData())
                .fixo(receita.getFixo())
                .descricao(receita.getDescricao())
                .categoriaNome(receita.getCategoria().getNome())
                .contaBancaria(receita.getContaBancaria())
                .build();
    }

    public static Receita toEntity(ReceitaRequestDto dto, Categoria categoria) {
        return Receita.builder()
                .valor(dto.getValor())
                .data(dto.getData())
                .fixo(dto.getFixo())
                .descricao(dto.getDescricao())
                .categoria(categoria)
                .contaBancaria(dto.getContaBancaria())
                .build();
    }

    public static void updateFromDto(ReceitaRequestDto dto, Receita receita) {
        receita.setValor(dto.getValor());
        receita.setData(dto.getData());
        receita.setFixo(dto.getFixo());
        receita.setDescricao(dto.getDescricao());
        receita.setContaBancaria(dto.getContaBancaria());
    }
}