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
public class Receita extends Transacao {

    private String contaBancaria;

    public void registrarContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
}