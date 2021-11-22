package br.com.fabrisal.plan.controller;

import br.com.fabrisal.plan.controller.dto.EstoqueDto;
import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.ProdutoDto;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.service.IEstoqueService;
import br.com.fabrisal.plan.service.IProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/estoque")
@CrossOrigin({"*"})
@Slf4j
public class EstoqueController {

    @Autowired
    private IEstoqueService estoqueService;

    @PostMapping("/ajustar-positivo")
    public void ajustarPositivo(@RequestBody ProdutoDto produtoDto) throws BusinessException {
        estoqueService.ajustarPositivo(produtoDto);
    }

    @GetMapping
    public List<EstoqueDto> findAll(){
        return estoqueService.findAll();
    }

}
