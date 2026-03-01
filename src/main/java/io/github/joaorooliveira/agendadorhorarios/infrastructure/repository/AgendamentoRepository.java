package io.github.joaorooliveira.agendadorhorarios.infrastructure.repository;

import io.github.joaorooliveira.agendadorhorarios.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio,
                                                           LocalDateTime dataHoraFinal);

    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    List<Agendamento> findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);
}
