package br.com.barberpro.api.dto;

import java.time.LocalDateTime;

public record DadosAgendamento(
        LocalDateTime dataHora,
        Long idBarbeiro,
        Long idServico
) {
}
