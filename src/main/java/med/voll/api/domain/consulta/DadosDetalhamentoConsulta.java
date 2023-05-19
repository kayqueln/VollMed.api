package med.voll.api.domain.consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDate data, LocalTime hora) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(), consulta.getHora());
    }
}
