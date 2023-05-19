package med.voll.api.controler;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendamentoDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private AgendamentoDeConsultas agendamento;


    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultas dados){
        var dto = agendamento.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody DadosCancelamentoConsulta dados){
        agendamento.cancelar(dados);
        return ResponseEntity.ok().body(dados);
    }
}
