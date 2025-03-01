package com.squad04.gestao_financeira.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "categoria")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;


//mappedBy = "categoria": Especifica o lado "mapeado" do relacionamento, ou seja, o campo categoria na classe Transacao
// é o responsável por fazer o mapeamento para a Categoria. Isso indica que a Categoria é o "lado inverso" do
// relacionamento e o transações são o "lado dono".

//cascade = CascadeType.ALL: A operação de cascata significa que qualquer operação realizada na Categoria será propagada
// para as Transacoes associadas a ela. Por exemplo, se você excluir uma categoria, todas as transações associadas a ela
// também serão excluídas automaticamente.

//orphanRemoval = true: Se uma transação for dissociada de uma categoria (ou seja, se a categoria deixar de referenciar
// essa transação), ela será automaticamente removida do banco de dados.
}