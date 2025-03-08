package com.squad04.gestao_financeira.dto;

import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Despesa;

public class DespesaMapper {

    public static DespesaResponseDto toResponseDto(Despesa despesa) {
        return DespesaResponseDto.builder()
                .valor(despesa.getValor())
                .data(despesa.getData())
                .fixo(despesa.getFixo())
                .descricao(despesa.getDescricao())
                .categoriaNome(despesa.getCategoria().getNome())
                .localDespesa(despesa.getLocalDespesa())
                .metodoPagamento(despesa.getMetodoPagamento())
                .build();
    }

    public static Despesa toEntity(DespesaRequestDto dto, Categoria categoria) {
        return Despesa.builder()
                .valor(dto.getValor())
                .data(dto.getData())
                .fixo(dto.getFixo())
                .descricao(dto.getDescricao())
                .categoria(categoria)
                .localDespesa(dto.getLocalDespesa())
                .metodoPagamento(dto.getMetodoPagamento())
                .build();
    }

    public static void updateFromDto(DespesaRequestDto dto, Despesa despesa) {
        despesa.setValor(dto.getValor());
        despesa.setData(dto.getData());
        despesa.setFixo(dto.getFixo());
        despesa.setDescricao(dto.getDescricao());
        despesa.setLocalDespesa(dto.getLocalDespesa());
        despesa.setMetodoPagamento(dto.getMetodoPagamento());
    }
}