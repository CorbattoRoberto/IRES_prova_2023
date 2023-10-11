package it.euris.javaacademy.teslabattery_dfa.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/ciclo")
@SecurityRequirement(name = "authentication")
public class CicloProduttivoController {
}
