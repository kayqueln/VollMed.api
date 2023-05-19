package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsultas dados){
        LocalDate dataConsulta = dados.data();
        LocalTime horaConsulta =  dados.hora();
        LocalDateTime dateAndHour = LocalDateTime.of(dataConsulta, horaConsulta);
        LocalDateTime agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dateAndHour).toMinutes();

        if (diferencaEmMinutos < 30){
            throw new ValidacaoException("A consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }
}
