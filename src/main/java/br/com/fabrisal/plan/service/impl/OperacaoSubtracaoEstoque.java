package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.controller.dto.EstoqueDto;
import br.com.fabrisal.plan.controller.dto.UpdateEstoque;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.model.EstoqueModel;
import br.com.fabrisal.plan.repository.EstoqueRepository;
import br.com.fabrisal.plan.service.OperacaoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OperacaoSubtracaoEstoque implements OperacaoEstoque {

    private static final String UPDATE_SUBTRACAO_ESTOQUE = "UPDATE_SUBTRACAO_ESTOQUE";

    @Autowired
    private EstoqueRepository estoqueRepository;


    @Override
    public void realizarOperacao(UpdateEstoque updateEstoque) throws BusinessException {
        EstoqueModel produto = estoqueRepository.findPorIdDoProduto(updateEstoque.getId()).orElseThrow(() -> new BusinessException("Não existe Estoque com id " + updateEstoque.getId()));
        processaAuditoria(produto, updateEstoque);
        produto.setQuantidade(produto.getQuantidade() - updateEstoque.getQuantidade());
        estoqueRepository.save(produto);
    }

    private void processaAuditoria(EstoqueModel estoqueAtual, UpdateEstoque updateEstoque) {

    }
}
