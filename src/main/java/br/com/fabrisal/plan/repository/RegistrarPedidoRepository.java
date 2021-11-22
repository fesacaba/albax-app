package br.com.fabrisal.plan.repository;

import br.com.fabrisal.plan.model.RegistraPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegistrarPedidoRepository extends MongoRepository<RegistraPedidoModel, Long> {

    List<RegistraPedidoModel> findAllByOrderByIdPedidoDesc();
}