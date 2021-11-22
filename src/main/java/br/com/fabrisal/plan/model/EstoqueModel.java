package br.com.fabrisal.plan.model;

import br.com.fabrisal.plan.controller.dto.EstoqueDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "estoque")
public class EstoqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProdutoModel produto;
    private Long quantidade;
    private LocalDateTime dataAtualizacao;

    public static EstoqueDto converter(EstoqueModel model){
        return EstoqueDto
                .builder()
                .id(model.getId())
                .produto(model.getProduto())
                .quantidade(model.getQuantidade())
                .dataAtualizacao(model.getDataAtualizacao())
                .build();
    }
}
