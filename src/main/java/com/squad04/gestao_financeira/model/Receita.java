package com.squad04.gestao_financeira.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Receita {

    // Attributes --->

    private String contaBancaria;

    // Attributes <---

    // Methods --->

    public String RegistrarTipoContaBancaria (){
        return contaBancaria;
    }

    //Methods <---

}
