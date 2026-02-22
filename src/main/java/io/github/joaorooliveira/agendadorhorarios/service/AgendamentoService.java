package io.github.joaorooliveira.agendadorhorarios.service;

import io.github.joaorooliveira.agendadorhorarios.infrastructure.entity.Agendamento;
import io.github.joaorooliveira.agendadorhorarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(),
                horaAgendamento, horaFim);

        if (Objects.nonNull(agendados)) {
            throw new RuntimeException("Horario ja esta preenchido");
        }
        return agendamentoRepository.save(agendamento);
    }
}
