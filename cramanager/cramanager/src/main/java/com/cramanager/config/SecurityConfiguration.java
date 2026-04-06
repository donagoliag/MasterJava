package com.cramanager.config;

import com.cramanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthentificationFilter jwtAuthentificationFilter;
    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request

                        // Les routes Public
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // Pour SYSADMIN
                        .requestMatchers("/api/v1/user/**").hasAuthority("ROLE_SYSADMIN")
                        .requestMatchers("/api/v1/mission/**").hasAuthority("ROLE_SYSADMIN")
                        .requestMatchers("/api/v1/affectation/**").hasAuthority("ROLE_SYSADMIN")
                        .requestMatchers("/api/v1/cra/*/valider").hasAuthority("ROLE_SYSADMIN")
                        .requestMatchers("/api/v1/cra/*/rejeter").hasAuthority("ROLE_SYSADMIN")
                        .requestMatchers("/api/v1/cra/*/invalider").hasAuthority("ROLE_SYSADMIN")
                        .requestMatchers("/api/v1/cra/non-soumis").hasAuthority("ROLE_SYSADMIN")

                        // Pour USER
                        .requestMatchers("/api/v1/cra/*/remplir-mois").hasAuthority("ROLE_USER")
                        .requestMatchers("/api/v1/cra/*/remplir-jour").hasAuthority("ROLE_USER")
                        .requestMatchers("/api/v1/cra/*/soumettre").hasAuthority("ROLE_USER")

                        // Pour SYS ADMIN ET COLLAB AUTHENTIFIES
                        .requestMatchers("/api/v1/cra/**").authenticated()

                        .anyRequest().authenticated()
                )
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService.userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}