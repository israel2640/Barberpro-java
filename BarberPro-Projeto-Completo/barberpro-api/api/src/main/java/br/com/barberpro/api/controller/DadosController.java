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
        return barbeiroRepository.findAll();
    }

    @GetMapping("/servicos")
    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }
}