package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.model.ClienteModel;
import br.com.fabrisal.plan.repository.ClienteRepository;
import br.com.fabrisal.plan.service.IClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void salvar(ClienteModel clienteModel) {
        clienteModel.setDateIn(LocalDateTime.now());
        clienteRepository.save(clienteModel);
    }

    @Override
    public List<ClienteModel> findAll() {

        return clienteRepository.findAll();
    }
}
