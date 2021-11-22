package br.com.fabrisal.plan.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UpdateEstoque {

    private Long id;
    private Long quantidade;
}
