package com.squad04.gestao_financeira.repository;

import com.squad04.gestao_financeira.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}