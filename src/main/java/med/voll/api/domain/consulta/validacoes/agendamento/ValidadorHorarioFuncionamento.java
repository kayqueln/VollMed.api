package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsultas dados){
        var dataConsulta = dados.data();
        var horaConsulta = dados.hora();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = horaConsulta.getHour() < 9;
        var deposDaAbertura = horaConsulta.getHour() > 18;

        if(domingo || antesDaAbertura || deposDaAbertura){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
