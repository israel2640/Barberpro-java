package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Agendamento;
import br.com.barberpro.api.domain.Cliente;
import br.com.barberpro.api.dto.DadosAgendamento;
import br.com.barberpro.api.dto.DadosDetalhamentoAgendamento; // Importe o DTO de resposta
import br.com.barberpro.api.repository.AgendamentoRepository;
import br.com.barberpro.api.repository.BarbeiroRepository;
import br.com.barberpro.api.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


        var agendamento = new Agendamento(null, dados.dataHora(), clienteLogado, barbeiro, servico);


        agendamentoRepository.save(agendamento);


        var dto = new DadosDetalhamentoAgendamento(agendamento);


        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!agendamentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        agendamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}