package br.com.fabrisal.plan.controller;

import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.PedidoParamsDto;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.service.IPedidoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/pedido")
@CrossOrigin({"*"})
@Slf4j
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;


    @GetMapping("/valor-em-aberto")
    public Double valorEmAberto() {
        return pedidoService.getValorEmAberto();
    }


    @PostMapping("/registrar-pedido")
    public void registrarPedido(@RequestBody PedidoDto pedidoDto) throws BusinessException {
        pedidoService.salvar(pedidoDto);
    }

    @PostMapping
    public List<PedidoDto> buscarPorParametros(@RequestBody PedidoParamsDto paransDto) {
        return pedidoService.buscarPorParametros(paransDto);
    }
}
