package it.euris.javaacademy.teslabattery_dfa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.javaacademy.teslabattery_dfa.config.security.SecurityConf;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;
import it.euris.javaacademy.teslabattery_dfa.repository.CatenaDiMontaggioRepository;
import it.euris.javaacademy.teslabattery_dfa.service.CatenaDiMontaggioService;
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
public class CatenaDiMontaggioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CatenaDiMontaggioService catenaDiMontaggioService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CatenaDiMontaggioRepository catenaDiMontaggioRepository;

    CatenaDiMontaggio createDummyCatenaDiMontaggio (Integer id) {
        return CatenaDiMontaggio.builder()
                .id(id)
                .build();
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldGetOneCatenaDiMontaggio() throws Exception {

        Integer id = 1;
        CatenaDiMontaggio catenaDiMontaggio = createDummyCatenaDiMontaggio(id);
        List<CatenaDiMontaggio> catenaDiMontaggios = List.of(catenaDiMontaggio);

        when(catenaDiMontaggioService.findAll()).thenReturn(catenaDiMontaggios);


        mockMvc.perform(MockMvcRequestBuilders.get("/catene/v1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(catenaDiMontaggio.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldInsertACatenaDiMontaggio() throws Exception {
        Integer id = 1;
        CatenaDiMontaggio catenaDiMontaggio = createDummyCatenaDiMontaggio(id);
        when(catenaDiMontaggioService.insert(any())).thenReturn(catenaDiMontaggio);

        mockMvc.perform(post("/catene/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(catenaDiMontaggio.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(catenaDiMontaggio.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldUpdateACatenaDiMontaggio() throws Exception {
        Integer id = 1;
        CatenaDiMontaggio catenaDiMontaggio = createDummyCatenaDiMontaggio(id);
        when(catenaDiMontaggioService.update(any())).thenReturn(catenaDiMontaggio);

        mockMvc.perform(put("/catene/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(catenaDiMontaggio.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(catenaDiMontaggio.getId()));
    }


    @Test
    @WithUserDetails(value = "supervisor")
    void shouldDelete() throws Exception {
        Integer id = 1;
        CatenaDiMontaggio catenaDiMontaggio = createDummyCatenaDiMontaggio(id);

        when(catenaDiMontaggioService.deleteById(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/catene/v1/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}