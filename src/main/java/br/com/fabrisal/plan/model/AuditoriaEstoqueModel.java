package br.com.fabrisal.plan.model;

import br.com.fabrisal.plan.controller.dto.EstoqueDto;
import br.com.fabrisal.plan.controller.dto.UpdateEstoque;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Data
@Document(collection = "auditoria")
public class AuditoriaEstoqueModel {

    @Id
    private ObjectId id;
    private String tipoOperacao;
    private LocalDateTime horaAtualizacao;
    private EstoqueDto estoqueAtual;
    private EstoqueDto estoqueNovo;
    private UpdateEstoque updateEstoque;
}
