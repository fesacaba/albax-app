package br.com.fabrisal.plan.repository;

import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.PedidoParamsDto;

import java.util.List;

public interface PedidoRepository {

    List<PedidoDto> query(PedidoParamsDto dto);
}
