package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.exception.NotExistsImplamentationExecption;
import br.com.fabrisal.plan.service.BeanService;
import br.com.fabrisal.plan.service.OperacaoEstoque;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class OperacaoBeanService implements BeanService<OperacaoEstoque> {

    private static final String TIPO_OPERACAO_ENTRADA = "entrada";
    Map<String, OperacaoEstoque> operacoes;

    @Override
    public OperacaoEstoque getBean(String nome) throws NotExistsImplamentationExecption {
        if (TIPO_OPERACAO_ENTRADA.equals(nome)) {
            return operacoes.get("operacaoSomaEstoque");
        } else {
            // TODO
            return operacoes.get("operacaoSubtracaoEstoque");
        }
    }


}
