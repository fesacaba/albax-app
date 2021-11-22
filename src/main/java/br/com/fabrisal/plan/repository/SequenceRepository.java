package br.com.fabrisal.plan.repository;

import br.com.fabrisal.plan.model.SequenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends JpaRepository<SequenceModel, Long> {

}
