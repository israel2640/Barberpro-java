package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {}
