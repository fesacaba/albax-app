package br.com.fabrisal.plan.repository;

import br.com.fabrisal.plan.model.AuditoriaEstoqueModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditoriaRepository  extends MongoRepository<AuditoriaEstoqueModel, Long> {
}
