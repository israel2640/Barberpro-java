package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Agendamento;
import br.com.barberpro.api.domain.Cliente;
import br.com.barberpro.api.domain.Barbeiro;
import br.com.barberpro.api.domain.enums.AgendamentoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findAllByCliente(Cliente cliente);
    List<Agendamento> findAllByBarbeiro(Barbeiro barbeiro);

    long deleteByIdAndCliente_Id(Long agendamentoId, Long clienteId);

    long deleteByIdAndBarbeiro_Id(Long agendamentoId, Long barbeiroId);

    Optional<Agendamento> findByIdAndBarbeiro_Id(Long agendamentoId, Long barbeiroId);

    long deleteAllByClienteAndStatus(Cliente cliente, AgendamentoStatus status);
    
    long deleteAllByBarbeiroAndStatus(Barbeiro barbeiro, AgendamentoStatus status);

    boolean existsByBarbeiroAndDataHora(Barbeiro barbeiro, LocalDateTime dataHora);
}