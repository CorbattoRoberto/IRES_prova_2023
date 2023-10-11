package it.euris.javaacademy.teslabattery;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "teslabattery_cv", version = "1.0", description = "Tesla Battery Management"))
@SecurityScheme(name = "authentication", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class TeslaBatteryCvApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeslaBatteryCvApplication.class, args);
    }

}
