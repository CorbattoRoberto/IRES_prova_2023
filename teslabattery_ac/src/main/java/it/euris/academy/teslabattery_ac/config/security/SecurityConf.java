package it.euris.academy.teslabattery_ac.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// Configurazione minima della security mancante.

@Configuration
public class SecurityConf {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((authorize) -> authorize
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults());
    return http.build();
  }

}
