package it.euris.javaacademy.teslabattery_dfa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.javaacademy.teslabattery_dfa.config.security.SecurityConf;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.Status;
import it.euris.javaacademy.teslabattery_dfa.repository.FormulaRepository;
import it.euris.javaacademy.teslabattery_dfa.service.CicliProduttivoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(value = {SecurityConf.class})
public class CicloProduttivoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CicliProduttivoService cicloProduttivoService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FormulaRepository formulaRepository;

    CicloProduttivo createDummyCiclo(Integer id) {
        return CicloProduttivo.builder()
                .id(id)
                .build();
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldGetOneCiclo() throws Exception {

        Integer id = 1;
        CicloProduttivo cicloProduttivo = createDummyCiclo(id);
        List<CicloProduttivo> cicliProduttivi = List.of(cicloProduttivo);

        when(cicloProduttivoService.findAll()).thenReturn(cicliProduttivi);


        mockMvc.perform(MockMvcRequestBuilders.get("/cycles/v1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(cicloProduttivo.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldInsertACiclo() throws Exception {
        Integer id = 1;
        CicloProduttivo cicloProduttivo = createDummyCiclo(id);
        when(cicloProduttivoService.insert(any())).thenReturn(cicloProduttivo);

        mockMvc.perform(post("/cycles/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cicloProduttivo.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(cicloProduttivo.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldUpdateACiclo() throws Exception {
        Integer id = 1;
        CicloProduttivo cicloProduttivo = createDummyCiclo(id);
        when(cicloProduttivoService.update(any())).thenReturn(cicloProduttivo);

        mockMvc.perform(put("/cycles/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cicloProduttivo.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(cicloProduttivo.getId()));
    }


    @Test
    @WithUserDetails(value = "supervisor")
    void shouldDelete() throws Exception {
        Integer id = 1;
        CicloProduttivo cicloProduttivo = createDummyCiclo(id);

        when(cicloProduttivoService.deleteById(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/cycles/v1/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    @Test
    @WithUserDetails(value = "supervisor")
    void shouldUpdateACicloStatus() throws Exception {
        Integer id = 1;
        Status preStatus = Status.TEST_QUALITA;
        CicloProduttivo cicloProduttivo = CicloProduttivo.builder()
                .status(preStatus)
                .lastStatusUpdate(LocalDateTime.now().minusHours(1))
                .id(id)
                .build();
        when(cicloProduttivoService.findById(id)).thenReturn(cicloProduttivo);
        when(cicloProduttivoService.update(any())).thenReturn(cicloProduttivo);

        mockMvc.perform(put("/cycles/v1/{id}-{status}", id, preStatus)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cicloProduttivo.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(cicloProduttivo.getId()))
                .andExpect(jsonPath("$.status").value(cicloProduttivo.getStatus().toString()))
        ;
    }

}
