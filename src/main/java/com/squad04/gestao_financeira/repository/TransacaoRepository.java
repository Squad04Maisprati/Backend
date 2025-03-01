package com.squad04.gestao_financeira.repository;

import com.squad04.gestao_financeira.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByCategoriaId(Long categoryId);

}
