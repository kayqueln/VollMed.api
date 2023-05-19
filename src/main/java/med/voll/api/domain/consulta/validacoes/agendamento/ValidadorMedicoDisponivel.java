package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoDisponivel implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultas dados){
        var medicoDisponivel = repository.existsByMedicoIdAndDataAndHora(dados.idMedico(), dados.data(), dados.hora());
        if(medicoDisponivel){
            throw new ValidacaoException("O médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
