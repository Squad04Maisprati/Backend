package com.squad04.gestao_financeira.repository;

import com.squad04.gestao_financeira.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}