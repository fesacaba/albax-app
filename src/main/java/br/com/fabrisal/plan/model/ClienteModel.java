package br.com.fabrisal.plan.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateIn;
    private String nomeFantasia;
    private String nomeProprietario;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private EnderecoModel enderecoModel;
    private String telefone;
}
