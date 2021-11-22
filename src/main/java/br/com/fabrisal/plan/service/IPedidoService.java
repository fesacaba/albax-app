package br.com.fabrisal.plan.service;

import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.PedidoParamsDto;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.model.SequenceModel;

import java.util.List;

public interface IPedidoService {

    void salvar(PedidoDto pedidoDto) throws BusinessException;

    List<PedidoDto> buscarPorParametros(PedidoParamsDto paransDto);

    SequenceModel getSequence();

    Double getValorEmAberto();
}
