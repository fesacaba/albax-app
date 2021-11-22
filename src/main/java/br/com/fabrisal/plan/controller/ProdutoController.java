package br.com.fabrisal.plan.controller;

import br.com.fabrisal.plan.model.ProdutoModel;
import br.com.fabrisal.plan.service.IProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/produto")
@CrossOrigin({"*"})
@Slf4j
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping("listar")
    public List<ProdutoModel> findAll() {
        return produtoService.findAll();
    }
}
