package it.euris.javaacademy.teslabattery.config.security;

import it.euris.javaacademy.teslabattery.data.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

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
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Le specifiche indicano che tutti gli endpoint devono essere accessibili da utenti con
        // ruolo SUPERVISOR, mentre qui i GET sono aperti a tutti

        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(whiteList.getUrls()).permitAll()
                        .requestMatchers(HttpMethod.GET, "/alive").permitAll()
                        .requestMatchers(HttpMethod.GET, "/assembly-lines/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/components/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/formula-components/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/robots/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/supervisors/**").permitAll()
                        .requestMatchers("/assembly-lines/**").hasRole(UserRole.ADMINISTRATOR.toString())
                        .requestMatchers("/components/**").hasRole(UserRole.ADMINISTRATOR.toString())
                        .requestMatchers("/formula-components/**").hasRole(UserRole.ADMINISTRATOR.toString())
                        .requestMatchers("/production-cycles/**").hasRole(UserRole.ADMINISTRATOR.toString())
                        .requestMatchers("/robots/**").hasRole(UserRole.ADMINISTRATOR.toString())
                        .requestMatchers("/supervisors/**").hasRole(UserRole.ADMINISTRATOR.toString())
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles(UserRole.USER.toString())
                .build();

        UserDetails admin = User.builder()
                .username("administrator")
                .password(passwordEncoder().encode("administrator"))
                .roles(UserRole.ADMINISTRATOR.toString())
                .build();

        UserDetails viewer = User.builder()
                .username("viewer")
                .password(passwordEncoder().encode("viewer"))
                .roles(UserRole.VIEWER.toString())
                .build();

        return new InMemoryUserDetailsManager(user, admin, viewer);

    }
}
