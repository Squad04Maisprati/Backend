package com.squad04.gestao_financeira.repository;

import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
