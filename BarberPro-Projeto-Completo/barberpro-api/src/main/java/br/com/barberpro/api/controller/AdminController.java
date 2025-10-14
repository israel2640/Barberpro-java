package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Agendamento;
import br.com.barberpro.api.domain.Barbeiro;
import br.com.barberpro.api.domain.Cliente;
import br.com.barberpro.api.dto.DadosDetalhamentoAgendamento;
import br.com.barberpro.api.repository.AgendamentoRepository;
import br.com.barberpro.api.repository.BarbeiroRepository;
import br.com.barberpro.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // --- Endpoint para Listar todos os Agendamentos ---
    @GetMapping("/agendamentos")
    public ResponseEntity<List<DadosDetalhamentoAgendamento>> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        List<DadosDetalhamentoAgendamento> agendamentosDTO = agendamentos.stream()
                .map(DadosDetalhamentoAgendamento::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(agendamentosDTO);
    }

    // --- Endpoints para Gerenciar Clientes (Usuários) ---
    @GetMapping("/usuarios")
    public ResponseEntity<List<Cliente>> listarUsuarios() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @DeleteMapping("/usuarios/{id}")
    @Transactional
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- Endpoints para Gerenciar Barbeiros ---
    @GetMapping("/barbeiros")
    public ResponseEntity<List<Barbeiro>> listarBarbeiros() {
        return ResponseEntity.ok(barbeiroRepository.findAll());
    }

    @PostMapping("/barbeiros")
    @Transactional
    public ResponseEntity<Barbeiro> criarBarbeiro(@RequestBody Barbeiro barbeiro) {
        // Criptografa a senha antes de salvar
        barbeiro.setSenha(passwordEncoder.encode(barbeiro.getSenha()));
        Barbeiro novoBarbeiro = barbeiroRepository.save(barbeiro);
        return ResponseEntity.ok(novoBarbeiro);
    }

    @DeleteMapping("/barbeiros/{id}")
    @Transactional
    public ResponseEntity<Void> excluirBarbeiro(@PathVariable Long id) {
        if (!barbeiroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        barbeiroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}