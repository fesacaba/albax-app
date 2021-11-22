package br.com.fabrisal.plan.model;

import br.com.fabrisal.plan.controller.dto.ClienteDto;
import br.com.fabrisal.plan.controller.dto.ProdutoDto;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Document(collection = "registraPedido")
public class RegistraPedidoModel {

    @Id
    private ObjectId id;
    private Long idPedido;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private ClienteDto cliente;
    private List<ProdutoDto> produtos;
    private Double valorPedido;
    private Boolean pagamento;
}
