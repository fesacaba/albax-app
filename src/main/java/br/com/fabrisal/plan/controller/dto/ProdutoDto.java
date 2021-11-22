package br.com.fabrisal.plan.controller.dto;

import lombok.Data;

@Data
public class ProdutoDto {

    private Long id;
    private Long quantidade;
    private String produto;
    private String recheio;
    private Double peso;
    private Double valorUnitario;
    private Double valorPorProduto;
}
