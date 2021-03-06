package br.com.fabrisal.plan.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PedidoDto {

    private String id;
    private Long idPedido;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private ClienteDto cliente;
    private List<ProdutoDto> produtos;
    private Double valorPedido;
    private Boolean pagamento;
}
