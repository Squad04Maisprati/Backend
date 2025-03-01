package com.squad04.gestao_financeira.controller;
import com.squad04.gestao_financeira.dto.TransacaoResponseDto;
import com.squad04.gestao_financeira.model.Categoria;
import com.squad04.gestao_financeira.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("categorias")
@Controller
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

}
