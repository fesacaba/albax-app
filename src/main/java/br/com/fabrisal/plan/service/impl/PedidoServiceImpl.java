package br.com.fabrisal.plan.service.impl;

import br.com.fabrisal.plan.controller.dto.PedidoDto;
import br.com.fabrisal.plan.controller.dto.PedidoParamsDto;
import br.com.fabrisal.plan.controller.dto.ProdutoDto;
import br.com.fabrisal.plan.exception.BusinessException;
import br.com.fabrisal.plan.model.RegistraPedidoModel;
import br.com.fabrisal.plan.model.SequenceModel;
import br.com.fabrisal.plan.repository.PedidoRepository;
import br.com.fabrisal.plan.repository.RegistrarPedidoRepository;
import br.com.fabrisal.plan.repository.SequenceRepository;
import br.com.fabrisal.plan.service.IEstoqueService;
import br.com.fabrisal.plan.service.IPedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private RegistrarPedidoRepository registrarPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private SequenceRepository sequenceRepository;

    @Autowired
    private IEstoqueService estoqueService;

    @Override
    public void salvar(PedidoDto pedidoDto) throws BusinessException {

        registrarPedidoRepository.save(converterToRegistraPedidoModel(pedidoDto));
        sequenceRepository.save(
                SequenceModel
                        .builder()
                        .id(pedidoDto.getSequence().getId())
                        .sequenceNumber(pedidoDto.getSequence().getSequenceNumber())
                        .build());
        for (ProdutoDto produtoDto : pedidoDto.getProdutos()) {
            estoqueService.atualizarEstoque(produtoDto);
        }
    }

    @Override

    public List<PedidoDto> buscarPorParametros(PedidoParamsDto paransDto) {
        return pedidoRepository.query(paransDto);
    }

    public SequenceModel getSequence() {
        Optional<SequenceModel> seq = sequenceRepository.findById(1L);
        SequenceModel sequence = seq.get();
        sequence.setSequenceNumber(sequence.getSequenceNumber() + 1L);

        return sequence;
    }

    @Override
    public Double getValorEmAberto() {
        List<RegistraPedidoModel> retorno = registrarPedidoRepository.findAll();
        double sum = retorno
                .stream()
                .filter(d -> d.getPagamento() == false)
                .mapToDouble(c -> c.getValorPedido())
                .sum();

        return sum;
    }

    private RegistraPedidoModel converterToRegistraPedidoModel(PedidoDto pedidoDto) {
        return RegistraPedidoModel.builder()
                .dataPedido(pedidoDto.getDataPedido())
                .idPedido(pedidoDto.getSequence().getSequenceNumber())
                .dataEntrega(pedidoDto.getDataEntrega())
                .cliente(pedidoDto.getCliente())
                .valorPedido(pedidoDto.getValorPedido())
                .produtos(pedidoDto.getProdutos())
                .pagamento(pedidoDto.getPagamento())
                .build();
    }
}
