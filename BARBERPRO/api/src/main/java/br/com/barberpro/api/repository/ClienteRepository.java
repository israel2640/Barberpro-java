package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    UserDetails findByEmail(String username);
}
