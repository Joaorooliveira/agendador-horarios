package io.github.joaorooliveira.agendadorhorarios.controller;

import io.github.joaorooliveira.agendadorhorarios.infrastructure.entity.Agendamento;
import io.github.joaorooliveira.agendadorhorarios.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
                                                   @RequestParam LocalDateTime dataHoraAgendamento) {
        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    public Agendamento alterarAgendament(Agendamento agendamento, String cliente, LocalDateTime dataHoraAgendamento) {
        return agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento);
    }

    @GetMapping
    public ResponseEntity<Agendamento> buscarAgendamentosDia(@RequestParam LocalDate data) {
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentos(data));
    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamento(@RequestParam String cliente,
                                                          @RequestParam LocalDateTime dataHoraAgendamento,
                                                          @RequestBody Agendamento agendamento) {
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
    }
}
