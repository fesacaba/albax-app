package br.com.fabrisal.plan.controller.dto;

import lombok.Data;

@Data
public class EnderecoDto {

    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String cep;
}
