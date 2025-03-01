package com.squad04.gestao_financeira.dto;

import lombok.*;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class TransacaoRequestDto {


    private Double valor;
    private LocalDate data;
    private String descricao;
    private Boolean fixo;
    private Long categoriaId;



}
