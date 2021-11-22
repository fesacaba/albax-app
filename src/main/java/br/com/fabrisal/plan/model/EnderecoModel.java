package br.com.fabrisal.plan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "enderco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String cep;
}
