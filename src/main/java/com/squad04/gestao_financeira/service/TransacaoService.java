package com.squad04.gestao_financeira.service;
import com.squad04.gestao_financeira.dto.TransacaoMapper;
import com.squad04.gestao_financeira.dto.TransacaoRequestDto;
import com.squad04.gestao_financeira.dto.TransacaoResponseDto;
import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.model.Transacao;
import com.squad04.gestao_financeira.repository.CategoriaRepository;
import com.squad04.gestao_financeira.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransacaoService {

    private CategoriaRepository categoriaRepository;
    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, CategoriaRepository categoriaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
    }


    public List<Transacao> getAll() {
        return transacaoRepository.findAll();

    }

    public TransacaoResponseDto getById(Long id) {
        Transacao transacaoById = transacaoRepository.findById(id).get();

        return TransacaoMapper.toResponseDto(transacaoById);
    }
    public TransacaoResponseDto create(TransacaoRequestDto transacaoRequestDto) {
        Categoria categoria = categoriaRepository.findById(transacaoRequestDto.getCategoriaId()).
                orElseThrow(() -> new RuntimeException("Categoria não encontrada"));


        Transacao transacaoToSave = TransacaoMapper.toEntity(transacaoRequestDto, categoria);
        Transacao transacaoCreated = transacaoRepository.save(transacaoToSave);
        return TransacaoMapper.toResponseDto(transacaoCreated);

    }

    public TransacaoResponseDto update(Long id, TransacaoRequestDto transacaoRequestDto) {
        Transacao transacaoExisting = transacaoRepository.findById(id).get();

        Categoria categoria = categoriaRepository.findById(transacaoRequestDto.getCategoriaId()).
                orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        TransacaoMapper.updateFromDto(transacaoRequestDto, transacaoExisting);
        transacaoExisting.setCategoria(categoria);

        Transacao transacaoToSave = transacaoRepository.save(transacaoExisting);
        return TransacaoMapper.toResponseDto(transacaoToSave);
    }

    public void deleteById(Long id) {

        transacaoRepository.deleteById(id);


    }
    public List<TransacaoResponseDto> getByCategoria(Long categoryId) {
        List<Transacao> transacoes = transacaoRepository.findByCategoriaId(categoryId);
        return transacoes.stream()
                .map(TransacaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }



}

