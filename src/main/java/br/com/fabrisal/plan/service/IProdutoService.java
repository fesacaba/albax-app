package br.com.fabrisal.plan.service;

import br.com.fabrisal.plan.model.ProdutoModel;

import java.util.List;

public interface IProdutoService {

    ProdutoModel salvar(ProdutoModel produtoModel);

    List<ProdutoModel> findAll();
}
