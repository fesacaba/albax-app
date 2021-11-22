package br.com.fabrisal.plan.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClienteDto {

    private Long id;
    private LocalDateTime dateIn;
    private String nomeFantasia;
    private String nomeProprietario;
    private EnderecoDto enderecoModel;
    private String telefone;
}
