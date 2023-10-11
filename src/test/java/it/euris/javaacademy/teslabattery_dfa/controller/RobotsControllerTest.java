package it.euris.javaacademy.teslabattery_dfa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.javaacademy.teslabattery_dfa.config.security.SecurityConf;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;
import it.euris.javaacademy.teslabattery_dfa.repository.RobotsRepository;
import it.euris.javaacademy.teslabattery_dfa.service.RobotsService;
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
public class RobotsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RobotsService robotsService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RobotsRepository robotsRepository;

    Robots createDummyrobot(Integer id) {
        return Robots.builder()
                .id(id)
                .build();
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldGetOnerobot() throws Exception {

        Integer id = 1;
        Robots robots = createDummyrobot(id);
        List<Robots> robotss = List.of(robots);

        when(robotsService.findAll()).thenReturn(robotss);


        mockMvc.perform(MockMvcRequestBuilders.get("/robots/v1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(robots.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldInsertArobot() throws Exception {
        Integer id = 1;
        Robots robots = createDummyrobot(id);
        when(robotsService.insert(any())).thenReturn(robots);

        mockMvc.perform(post("/robots/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(robots.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(robots.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldUpdateArobot() throws Exception {
        Integer id = 1;
        Robots robots = createDummyrobot(id);
        when(robotsService.update(any())).thenReturn(robots);

        mockMvc.perform(put("/robots/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(robots.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(robots.getId()));
    }


    @Test
    @WithUserDetails(value = "supervisor")
    void shouldDelete() throws Exception {
        Integer id = 1;
        Robots robots = createDummyrobot(id);
        List<Robots> robotss = List.of(robots);

        when(robotsService.deleteById(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/robots/v1/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}