package br.com.barberpro.api.service;

import br.com.barberpro.api.repository.BarbeiroRepository; // 1. Importe o BarbeiroRepository
import br.com.barberpro.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository; // 2. Injete o BarbeiroRepository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 3. Lógica atualizada para procurar em ambos os repositórios
        
        // Primeiro, tenta encontrar como um cliente
        UserDetails user = clienteRepository.findByEmail(username);
        
        // Se não encontrou como cliente, tenta encontrar como um barbeiro
        if (user == null) {
            user = barbeiroRepository.findByEmail(username);
        }

        // Se não encontrou em nenhum dos dois, o login é inválido
        if (user == null) {
            throw new UsernameNotFoundException("Dados de login inválidos!");
        }

        return user;
    }
}