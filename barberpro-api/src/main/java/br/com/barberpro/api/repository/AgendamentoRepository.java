package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Agendamento;
import br.com.barberpro.api.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.barberpro.api.domain.Barbeiro;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findAllByCliente(Cliente cliente);
    List<Agendamento> findAllByBarbeiro(Barbeiro barbeiro);
}