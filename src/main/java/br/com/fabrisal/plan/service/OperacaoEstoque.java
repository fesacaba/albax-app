package br.com.fabrisal.plan.service;

import br.com.fabrisal.plan.controller.dto.UpdateEstoque;
import br.com.fabrisal.plan.exception.BusinessException;

public interface OperacaoEstoque {
    void realizarOperacao(UpdateEstoque updateEstoque) throws  BusinessException;
}
