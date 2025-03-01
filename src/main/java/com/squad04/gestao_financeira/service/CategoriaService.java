package com.squad04.gestao_financeira.service;
import com.squad04.gestao_financeira.dto.TransacaoMapper;
import com.squad04.gestao_financeira.dto.TransacaoResponseDto;
import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Transacao;
import com.squad04.gestao_financeira.repository.CategoriaRepository;
import com.squad04.gestao_financeira.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }



}
