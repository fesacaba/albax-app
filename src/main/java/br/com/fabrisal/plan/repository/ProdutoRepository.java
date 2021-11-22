package br.com.fabrisal.plan.repository;

import br.com.fabrisal.plan.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    List<ProdutoModel> findAllByOrderByIdAsc();
}
