package it.euris.javaacademy.teslabattery_dfa.config.security;

import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConf {

    private final WhiteListConfiguration whiteList;

    private final CorsFilter corsFilter;

    public SecurityConf(WhiteListConfiguration whiteList, CorsFilter corsFilter) {
        this.whiteList = whiteList;
        this.corsFilter = corsFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(whiteList.getUrls()).permitAll()
                        .requestMatchers(HttpMethod.GET).hasRole(UserRole.SUPERVISOR.toString())
                        .requestMatchers(HttpMethod.POST).hasRole(UserRole.SUPERVISOR.toString())
                        .requestMatchers(HttpMethod.PUT).hasRole(UserRole.SUPERVISOR.toString())
                        .requestMatchers(HttpMethod.DELETE).hasRole(UserRole.SUPERVISOR.toString())
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();
    }
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails supervisor = User.builder()
                .username("tesla_supervisor")
                .password(passwordEncoder().encode("tesla"))
                .roles(UserRole.SUPERVISOR.toString())
                .build();

        UserDetails visitor = User.builder()
                .username("visitor")
                .password(passwordEncoder().encode("visitor"))
                .roles(UserRole.VISITOR.toString())
                .build();
        UserDetails supervisor1 = User.builder()
                .username("supervisor")
                .password(passwordEncoder().encode("supervisor"))
                .roles(UserRole.SUPERVISOR.toString())
                .build();

        return new InMemoryUserDetailsManager(supervisor, visitor, supervisor1);
    }


}
