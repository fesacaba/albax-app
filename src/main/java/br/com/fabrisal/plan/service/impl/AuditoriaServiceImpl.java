package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.model.AuditoriaEstoqueModel;
import br.com.fabrisal.plan.repository.AuditoriaRepository;
import br.com.fabrisal.plan.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public void run(AuditoriaEstoqueModel build) {
        auditoriaRepository.save(build);
    }
}
