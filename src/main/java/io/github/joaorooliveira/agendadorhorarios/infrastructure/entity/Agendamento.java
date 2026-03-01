package io.github.joaorooliveira.agendadorhorarios.infrastructure.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String servico;

    private String profissional;

    private LocalDateTime dataHoraAgendamento;

    private String cliente;

    private String telefoneCliente;

    private LocalDateTime dataInsercao = LocalDateTime.now();
}
