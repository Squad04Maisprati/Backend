package com.squad04.gestao_financeira.dto;
import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Transacao;


public class TransacaoMapper {

    public static TransacaoResponseDto toResponseDto(Transacao transacao){
        return TransacaoResponseDto.builder()
                .valor(transacao.getValor())
                .data(transacao.getData())
                .fixo(transacao.getFixo())
                .descricao(transacao.getDescricao())
                .categoriaNome(transacao.getCategoria().getNome())
                .build();
    }

    public static Transacao toEntity(TransacaoRequestDto dto, Categoria category){
        return Transacao.builder()
                .valor(dto.getValor())
                .data(dto.getData())
                .fixo(dto.getFixo())
                .descricao(dto.getDescricao())
                .categoria(category)
                .build();
    }

    public static void updateFromDto(TransacaoRequestDto dto, Transacao transacao){

        transacao.setValor(dto.getValor());
        transacao.setData(dto.getData());
        transacao.setFixo(dto.getFixo());
        transacao.setDescricao(dto.getDescricao());

    }
















}
