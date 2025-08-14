package br.com.barberpro.api.repository;

import br.com.barberpro.api.domain.Agendamento;
import br.com.barberpro.api.domain.Cliente; // Importe a classe Cliente
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List; // Importe a classe List

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findAllByCliente(Cliente cliente);

}