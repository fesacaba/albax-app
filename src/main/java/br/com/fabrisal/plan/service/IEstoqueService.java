package br.com.fabrisal.plan.service;

import br.com.fabrisal.plan.controller.dto.EstoqueDto;
import br.com.fabrisal.plan.controller.dto.ProdutoDto;
import br.com.fabrisal.plan.exception.BusinessException;

import java.util.List;

public interface IEstoqueService {

    void atualizarEstoque(ProdutoDto produtos) throws BusinessException;

    void ajustarPositivo(ProdutoDto produtoDto) throws BusinessException;

    List<EstoqueDto> findAll();
}
