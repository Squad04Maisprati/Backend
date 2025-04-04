package com.squad04.gestao_financeira.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Despesa extends Transacao {

    private String localDespesa;
    private String metodoPagamento;

    public void registrarLocalDespesa(String localDespesa) {
        this.localDespesa = localDespesa;
    }

    public void registrarMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}