package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.controller.dto.EstoqueDto;
import br.com.fabrisal.plan.controller.dto.ProdutoDto;
import br.com.fabrisal.plan.controller.dto.UpdateEstoque;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.model.EstoqueModel;
import br.com.fabrisal.plan.repository.EstoqueRepository;
import br.com.fabrisal.plan.service.AuditoriaService;
import br.com.fabrisal.plan.service.BeanService;
import br.com.fabrisal.plan.service.IEstoqueService;
import br.com.fabrisal.plan.service.OperacaoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueServiceImpl implements IEstoqueService {

    @Autowired
    private BeanService<OperacaoEstoque> beanService;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public void atualizarEstoque(ProdutoDto produtos) throws BusinessException {
        updateEstoque(produtos, "saida");
    }

    @Override
    public void ajustarPositivo(ProdutoDto produtoDto) throws BusinessException {
        updateEstoque(produtoDto, "entrada");
    }

    @Override
    public List<EstoqueDto> findAll() {
        List<EstoqueModel> retorno = estoqueRepository.findAllByOrderByIdAsc();
        return retorno.stream()
                .map(this::converterEstoqueDto)
                .collect(Collectors.toList());
    }

    private EstoqueDto converterEstoqueDto(EstoqueModel estoqueModel) {
        return EstoqueDto
                .builder()
                .id(estoqueModel.getId())
                .produto(estoqueModel.getProduto())
                .dataAtualizacao(estoqueModel.getDataAtualizacao())
                .quantidade(estoqueModel.getQuantidade())
                .build();
    }

    private void updateEstoque(ProdutoDto produtoDto, String tipoOperacao) throws BusinessException {
        OperacaoEstoque operacaoEstoque = beanService.getBean(tipoOperacao);
        operacaoEstoque.realizarOperacao(UpdateEstoque.builder().id(produtoDto.getId()).quantidade(produtoDto.getQuantidade()).build());
    }
}
