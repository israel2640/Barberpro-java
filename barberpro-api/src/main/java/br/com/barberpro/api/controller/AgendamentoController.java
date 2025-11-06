package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Agendamento;
import br.com.barberpro.api.domain.Barbeiro;
import br.com.barberpro.api.domain.Cliente;
import br.com.barberpro.api.domain.enums.AgendamentoStatus;
import br.com.barberpro.api.dto.DadosAgendamento;
import br.com.barberpro.api.dto.DadosDetalhamentoAgendamento;
import br.com.barberpro.api.repository.AgendamentoRepository;
import br.com.barberpro.api.repository.BarbeiroRepository;
import br.com.barberpro.api.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoAgendamento>> listar(@AuthenticationPrincipal Cliente clienteLogado) {
        var agendamentos = agendamentoRepository.findAllByCliente(clienteLogado);
        var agendamentosDTO = agendamentos.stream()
                .map(DadosDetalhamentoAgendamento::new)
                .toList();
        return ResponseEntity.ok(agendamentosDTO);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAgendamento> criar(@AuthenticationPrincipal Cliente clienteLogado, @RequestBody @Valid DadosAgendamento dados) {
        var barbeiro = barbeiroRepository.findById(dados.idBarbeiro()).orElseThrow();
        var servico = servicoRepository.findById(dados.idServico()).orElseThrow();

        var agendamento = new Agendamento(null, dados.dataHora(), AgendamentoStatus.AGENDADO, clienteLogado, barbeiro, servico);

        agendamentoRepository.save(agendamento);

        var dto = new DadosDetalhamentoAgendamento(agendamento);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {

        long deleteCount = 0;

        if (userDetails instanceof Cliente cliente) {
            deleteCount = agendamentoRepository.deleteByIdAndCliente_Id(id, cliente.getId());

        } else if (userDetails instanceof Barbeiro barbeiro) {
            deleteCount = agendamentoRepository.deleteByIdAndBarbeiro_Id(id, barbeiro.getId());

        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        if (deleteCount == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/concluir")
    @Transactional
    public ResponseEntity<Void> concluir(@PathVariable Long id, @AuthenticationPrincipal Barbeiro barbeiroLogado) {

        var agendamentoOptional = agendamentoRepository.findByIdAndBarbeiro_Id(id, barbeiroLogado.getId());

        if (agendamentoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var agendamento = agendamentoOptional.get();
        agendamento.setStatus(AgendamentoStatus.CONCLUIDO);
        agendamentoRepository.save(agendamento);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/historico")
    @Transactional
    public ResponseEntity<Void> limparHistorico(@AuthenticationPrincipal Cliente clienteLogado) {
        agendamentoRepository.deleteAllByClienteAndStatus(clienteLogado, AgendamentoStatus.CONCLUIDO);
        return ResponseEntity.noContent().build();
    }
}