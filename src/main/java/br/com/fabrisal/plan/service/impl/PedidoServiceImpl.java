package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.PedidoParamsDto;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.service.IEstoqueService;
import br.com.fabrisal.plan.service.IPedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PedidoServiceImpl implements IPedidoService {


    @Autowired
    private IEstoqueService estoqueService;

    @Override
    public void salvar(PedidoDto pedidoDto) throws BusinessException {


    }

    @Override

    public List<PedidoDto> buscarPorParametros(PedidoParamsDto paransDto) {
        return null;
    }


    @Override
    public Double getValorEmAberto() {
        return null;
    }


}
