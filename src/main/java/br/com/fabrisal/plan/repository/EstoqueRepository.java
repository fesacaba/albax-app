package br.com.fabrisal.plan.repository;

import br.com.fabrisal.plan.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {

    @Query(value = "SELECT * FROM estoque e WHERE produto_id = :id", nativeQuery = true)
    Optional<EstoqueModel> findPorIdDoProduto(@Param("id") Long id);

    List<EstoqueModel> findAllByOrderByIdAsc();
}
