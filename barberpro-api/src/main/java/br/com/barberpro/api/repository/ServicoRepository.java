package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {}
