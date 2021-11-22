package br.com.fabrisal.plan.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateIn;
    private String nome;
    private String recheio;
    private Double valor;
    private Integer unidade;
    private Double peso;
    private Boolean status;
}
