package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Cliente;
import br.com.barberpro.api.dto.DadosCadastroCliente;
import br.com.barberpro.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // <-- IMPORTANTE
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public Cliente criar(@RequestBody DadosCadastroCliente dados) {
        
        var cliente = new Cliente();
        cliente.setNome(dados.nome());
        cliente.setEmail(dados.email());
                
        cliente.setRoles("USER"); 

        String senhaCriptografada = passwordEncoder.encode(dados.senha());
        cliente.setSenha(senhaCriptografada);

        return clienteRepository.save(cliente);
    }
}