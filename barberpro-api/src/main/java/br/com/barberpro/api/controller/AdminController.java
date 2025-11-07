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

    @GetMapping("/agendamentos")
    public ResponseEntity<List<DadosDetalhamentoAgendamento>> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return ResponseEntity.ok(agendamentos.stream().map(DadosDetalhamentoAgendamento::new).collect(Collectors.toList()));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Cliente>> listarUsuarios() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }
    
    @PutMapping("/usuarios/{id}")
    @Transactional
    public ResponseEntity<Cliente> editarUsuario(@PathVariable Long id, @RequestBody Cliente dados) {
        var usuario = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        if (dados.getSenha() != null && !dados.getSenha().isBlank()) {
            usuario.setSenha(passwordEncoder.encode(dados.getSenha()));
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @Transactional
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/barbeiros")
    public ResponseEntity<List<Barbeiro>> listarBarbeiros() {
        return ResponseEntity.ok(barbeiroRepository.findAll());
    }

    @PostMapping("/barbeiros")
    @Transactional
    public ResponseEntity<Barbeiro> criarBarbeiro(@RequestBody Barbeiro barbeiro) {
        barbeiro.setSenha(passwordEncoder.encode(barbeiro.getSenha()));
        return ResponseEntity.ok(barbeiroRepository.save(barbeiro));
    }
    
    @PutMapping("/barbeiros/{id}")
    @Transactional
    public ResponseEntity<Barbeiro> editarBarbeiro(@PathVariable Long id, @RequestBody Barbeiro dados) {
        var barbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
        
        barbeiro.setNome(dados.getNome());
        barbeiro.setEmail(dados.getEmail());
        barbeiro.setUrlImagem(dados.getUrlImagem());

        if (dados.getSenha() != null && !dados.getSenha().isBlank()) {
            barbeiro.setSenha(passwordEncoder.encode(dados.getSenha()));
        }
        
        return ResponseEntity.ok(barbeiroRepository.save(barbeiro));
    }

    @DeleteMapping("/barbeiros/{id}")
    @Transactional
    public ResponseEntity<Void> excluirBarbeiro(@PathVariable Long id) {
        barbeiroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}