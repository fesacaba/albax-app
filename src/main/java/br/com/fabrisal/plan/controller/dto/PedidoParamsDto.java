package br.com.fabrisal.plan.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Data
@Builder
public class PedidoParamsDto {

    private Long idCliente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @ApiModelProperty(example = "2019-12-01")
    private LocalDate dataInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @ApiModelProperty(example = "2019-12-30")
    private LocalDate dataFinal;
    private Boolean pagamento;

}
