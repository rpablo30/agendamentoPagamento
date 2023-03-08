package io.github.rpablo30.Rodrigo.Pablo.repository;

import io.github.rpablo30.Rodrigo.Pablo.entidades.Agendamento;
import io.github.rpablo30.Rodrigo.Pablo.entidades.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    public Optional<Agendamento>findByStatus(StatusPagamento status);
}
