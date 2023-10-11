package it.euris.javaacademy.teslabattery.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SecurityRequirement(name = "authentication")
public class TeslaBatteryCvApplicationController {

    @ResponseBody
    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    public String isAlive() {

        return "I'm alive!!!";
    }
}
