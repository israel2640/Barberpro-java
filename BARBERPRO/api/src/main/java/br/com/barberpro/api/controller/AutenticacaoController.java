package br.com.barberpro.api.controller;

import br.com.barberpro.api.domain.Cliente;
import br.com.barberpro.api.dto.DadosAutenticacao;
import br.com.barberpro.api.dto.DadosTokenJWT;
import br.com.barberpro.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);


        var tokenJWT = tokenService.gerarToken((Cliente) authentication.getPrincipal());


        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}