package med.voll.api.controler;

import med.voll.api.domain.consulta.AgendamentoDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.medico.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;


import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_TIME;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoConsultas> dadosAgendamentoConsultasJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultasJson;

    @MockBean
    private AgendamentoDeConsultas agendamentoDeConsultas;

    @Test
    @DisplayName("Deveria devolver o código http 400 quando as informações forem inválidas")
    @WithMockUser
    void agendarCenario1() throws Exception {
        var response = mvc.perform(post("/consulta")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    /*
    @Test
    @DisplayName("Deveria devolver o código http 200 quando as informações forem válidas")
    @WithMockUser
    void agendarCenario2() throws Exception {
        var data = LocalDate.now();
        var hora = LocalTime.now().plusHours(1);
        var especialidade = Especialidade.CARDIOLOGIA;

        var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 2l, 5l, data, hora);

        when(agendamentoDeConsultas.agendar(any())).thenReturn(dadosDetalhamento);

        var response = mvc.
                perform(
                        post("/consulta")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosAgendamentoConsultasJson.write(
                                        new DadosAgendamentoConsultas(2l, 5l, data, hora, especialidade)
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoConsultasJson.write(
                dadosDetalhamento
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }*/

}