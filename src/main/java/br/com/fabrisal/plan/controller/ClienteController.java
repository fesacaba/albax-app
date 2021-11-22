package br.com.fabrisal.plan.controller;

import br.com.fabrisal.plan.model.ClienteModel;
import br.com.fabrisal.plan.service.IClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/cliente")
@CrossOrigin({"*"})
@Slf4j
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("listar")
    public List<ClienteModel> findAll(Model model) {
        return clienteService.findAll();
    }
}
