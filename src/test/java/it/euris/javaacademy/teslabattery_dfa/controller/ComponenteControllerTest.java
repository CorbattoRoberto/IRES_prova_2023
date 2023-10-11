package it.euris.javaacademy.teslabattery_dfa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.javaacademy.teslabattery_dfa.config.security.SecurityConf;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;
import it.euris.javaacademy.teslabattery_dfa.repository.ComponenteRepository;
import it.euris.javaacademy.teslabattery_dfa.service.ComponenteService;
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
public class ComponenteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ComponenteService componenteService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ComponenteRepository componenteRepository;

    Componente createDummyComponente(Integer id) {
        return Componente.builder()
                .id(id)
                .build();
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldGetOneComponente() throws Exception {

        Integer id = 1;
        Componente componente = createDummyComponente(id);
        List<Componente> componenti = List.of(componente);

        when(componenteService.findAll()).thenReturn(componenti);


        mockMvc.perform(MockMvcRequestBuilders.get("/componente/v1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(componente.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldInsertAComponente() throws Exception {
        Integer id = 1;
        Componente componente = createDummyComponente(id);
        when(componenteService.insert(any())).thenReturn(componente);

        mockMvc.perform(post("/componente/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(componente.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(componente.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldUpdateAComponente() throws Exception {
        Integer id = 1;
        Componente componente = createDummyComponente(id);

        when(componenteService.update(any())).thenReturn(componente);

        mockMvc.perform(put("/componente/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(componente.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(componente.getId()));
    }


    @Test
    @WithUserDetails(value = "supervisor")
    void shouldDelete() throws Exception {
        Integer id = 1;
        Componente componente = createDummyComponente(id);

        when(componenteService.deleteById(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/componente/v1/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}