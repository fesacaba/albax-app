package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.model.ProdutoModel;
import br.com.fabrisal.plan.repository.ProdutoRepository;
import br.com.fabrisal.plan.service.IProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoModel salvar(ProdutoModel produtoModel) {
        produtoModel.setDateIn(LocalDateTime.now());
        return produtoRepository.save(produtoModel);
    }

    @Override
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAllByOrderByIdAsc();
    }
}
