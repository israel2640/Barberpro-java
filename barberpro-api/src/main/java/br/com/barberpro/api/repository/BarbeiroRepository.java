package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
    UserDetails findByEmail(String email);
}
