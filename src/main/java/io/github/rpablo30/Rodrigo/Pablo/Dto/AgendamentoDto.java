package io.github.rpablo30.Rodrigo.Pablo.Dto;

import io.github.rpablo30.Rodrigo.Pablo.entidades.Agendamento;
import io.github.rpablo30.Rodrigo.Pablo.entidades.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDto {

    private BigDecimal pagarValor;
    private StatusPagamento status;

    public AgendamentoDto(Agendamento ag) {

        this.pagarValor = ag.getPagarValor();
    }
}
