package br.com.fabrisal.plan.service;

import br.com.fabrisal.plan.model.ClienteModel;

import java.util.List;

public interface IClienteService {
    void salvar(ClienteModel clienteModel);

    List<ClienteModel> findAll();
}
