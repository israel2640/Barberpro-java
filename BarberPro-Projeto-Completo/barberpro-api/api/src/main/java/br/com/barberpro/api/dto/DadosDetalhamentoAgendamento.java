package br.com.barberpro.api.dto;

import br.com.barberpro.api.domain.Agendamento;
import java.time.LocalDateTime;

public record DadosDetalhamentoAgendamento(
        Long id,
        LocalDateTime dataHora,
        String nomeCliente,
        String nomeBarbeiro,
        String nomeServico,
        java.math.BigDecimal precoServico
) {

    public DadosDetalhamentoAgendamento(Agendamento agendamento) {
        this(
                agendamento.getId(),
                agendamento.getDataHora(),
                agendamento.getCliente().getNome(),
                agendamento.getBarbeiro().getNome(),
                agendamento.getServico().getNome(),
                agendamento.getServico().getPreco()
        );
    }
}
