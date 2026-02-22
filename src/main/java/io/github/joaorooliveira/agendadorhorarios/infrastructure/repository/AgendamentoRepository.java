package io.github.joaorooliveira.agendadorhorarios.infrastructure.repository;

import io.github.joaorooliveira.agendadorhorarios.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
