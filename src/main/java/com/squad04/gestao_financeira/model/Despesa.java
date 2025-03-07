package com.squad04.gestao_financeira.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Despesa extends Transacao {

    // Attributes --->

    private String LocalDespesa;

    private String MetodoPagamento;

    //Attributes <---

    // Methods --->

    public String RegistrarLocalDespesa() {
        return LocalDespesa;
    }

    public String RegistrarMetodoPagamento(){
        return MetodoPagamento;
    }

    // Methods <---

}
