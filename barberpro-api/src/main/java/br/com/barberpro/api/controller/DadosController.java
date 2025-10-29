package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Barbeiro;
import br.com.barberpro.api.domain.Servico;
import br.com.barberpro.api.repository.BarbeiroRepository;
import br.com.barberpro.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dados")
public class DadosController {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping("/barbeiros")
    public List<Barbeiro> listarBarbeiros() {
        // --- LOG ADICIONADO ---
        System.out.println("--- LOG BACKEND: Endpoint /api/dados/barbeiros foi chamado. ---");
        
        List<Barbeiro> barbeiros = barbeiroRepository.findAll();
        
        // --- LOG ADICIONADO ---
        System.out.println("--- LOG BACKEND: " + barbeiros.size() + " barbeiros encontrados no banco. ---");
        
        return barbeiros;
    }

    @GetMapping("/servicos")
    public List<Servico> listarServicos() {
        // --- LOG ADICIONADO ---
        System.out.println("--- LOG BACKEND: Endpoint /api/dados/servicos foi chamado. ---");
        
        List<Servico> servicos = servicoRepository.findAll();
        
        // --- LOG ADICIONADO ---
        System.out.println("--- LOG BACKEND: " + servicos.size() + " serviços encontrados no banco. ---");
        
        return servicos;
    }
}