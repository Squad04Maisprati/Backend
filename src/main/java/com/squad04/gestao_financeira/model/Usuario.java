package com.squad04.gestao_financeira.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;


@Table(name = "tb_usuarios")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "numCelular")
    private String numCelular;

    @CreationTimestamp
    private Instant creationTimestamp;
//Quando é criada/ atualizada (create e update)

    @updateTimesTamp
    private Instant updatedTimestamp;

    public usuario() {
    }

    public usuario(String username, String email, String senha, String cpf, String numCelular){
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.numCelular = numCelular;
        this.creationTimestamp = creationTimestamp;
        this.updatedTimestamp = updatedTimestamp;

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNumCelular() {
        return numCelular;
    }
    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }
    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }
    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
    public Instant getUpdatedTimestamp() {
        return updatedTimestamp;
    }
    public void setUpdatedTimestamp(Instant updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}