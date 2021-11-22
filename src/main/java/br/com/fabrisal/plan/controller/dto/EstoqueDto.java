package br.com.fabrisal.plan.controller.dto;

import br.com.fabrisal.plan.model.ProdutoModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EstoqueDto {

    private Long id;
    private ProdutoModel produto;
    private Long quantidade;
    private LocalDateTime dataAtualizacao;
}
