package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Barbeiro;
import br.com.barberpro.api.domain.enums.AgendamentoStatus;
import br.com.barberpro.api.dto.DadosDetalhamentoAgendamento;
import br.com.barberpro.api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping("/agendamentos")
    public ResponseEntity<List<DadosDetalhamentoAgendamento>> listarAgendamentos(@AuthenticationPrincipal Barbeiro barbeiroLogado) {
        var agendamentos = agendamentoRepository.findAllByBarbeiro(barbeiroLogado);

        var agendamentosDTO = agendamentos.stream()
                .map(DadosDetalhamentoAgendamento::new)
                .toList();

        return ResponseEntity.ok(agendamentosDTO);
    }

    @DeleteMapping("/historico")
    @Transactional
    public ResponseEntity<Void> limparHistoricoBarbeiro(@AuthenticationPrincipal Barbeiro barbeiroLogado) {
        agendamentoRepository.deleteAllByBarbeiroAndStatus(barbeiroLogado, AgendamentoStatus.CONCLUIDO);
        return ResponseEntity.noContent().build();
    }
}