package br.com.fabrisal.plan.repository.impl;

import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.PedidoParamsDto;
import br.com.fabrisal.plan.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRespositoryImpl implements PedidoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<PedidoDto> query(PedidoParamsDto dto) {

        Query dynamicQuery = new Query();

        if (dto.getIdCliente() != null) {
            Criteria nameCriteria = Criteria.where("cliente._id").is(dto.getIdCliente());
            dynamicQuery.addCriteria(nameCriteria);
        }

//        if (dto.getSequence().getSequenceNumber() != null) {
//            Criteria nameCriteria = Criteria.where("idPedido").is(dto.getSequence().getSequenceNumber() );
//            dynamicQuery.addCriteria(nameCriteria);
//        }

        if (dto.getDataInicial() != null && dto.getDataFinal() != null) {
            dynamicQuery.addCriteria(Criteria.where("dataPedido").gte(dto.getDataInicial()).lt(dto.getDataFinal()));
        }

        if (dto.getPagamento() != null) {
            dynamicQuery.addCriteria(Criteria.where("pagamento").is(dto.getPagamento()));
        }

        dynamicQuery.with(Sort.by(Sort.Direction.DESC, "dataPedido"));


        return mongoTemplate.find(dynamicQuery, PedidoDto.class, "registraPedido");
    }
}
