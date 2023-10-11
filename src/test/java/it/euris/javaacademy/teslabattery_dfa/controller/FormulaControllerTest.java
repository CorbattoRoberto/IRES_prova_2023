package it.euris.javaacademy.teslabattery_dfa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.javaacademy.teslabattery_dfa.config.security.SecurityConf;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Formula;
import it.euris.javaacademy.teslabattery_dfa.repository.FormulaRepository;
import it.euris.javaacademy.teslabattery_dfa.service.FormulaService;
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
public class FormulaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FormulaService formulaService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FormulaRepository formulaRepository;

    Formula createDummyFormula(Integer id) {
        return Formula.builder()
                .id(id)
                .build();
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldGetOneFormula() throws Exception {

        Integer id = 1;
        Formula formula = createDummyFormula(id);
        List<Formula> formulas = List.of(formula);

        when(formulaService.findAll()).thenReturn(formulas);


        mockMvc.perform(MockMvcRequestBuilders.get("/formula/v1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(formula.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldInsertAFormula() throws Exception {
        Integer id = 1;
        Formula formula = createDummyFormula(id);
        when(formulaService.insert(any())).thenReturn(formula);

        mockMvc.perform(post("/formula/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(formula.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(formula.getId()));
    }

    @Test
    @WithUserDetails(value = "supervisor")
    void shouldUpdateAFormula() throws Exception {
        Integer id = 1;
        Formula formula = createDummyFormula(id);
        when(formulaService.update(any())).thenReturn(formula);

        mockMvc.perform(put("/formula/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(formula.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(formula.getId()));
    }


    @Test
    @WithUserDetails(value = "supervisor")
    void shouldDelete() throws Exception {
        Integer id = 1;
        Formula formula = createDummyFormula(id);
        List<Formula> formulas = List.of(formula);

        when(formulaService.deleteById(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/formula/v1/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
