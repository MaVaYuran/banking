package by.mariayun.secutiry;

import by.mariayun.data.DataConfiguration;
import by.mariayun.service.ServiceConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.web.servlet.handler.*;


@Configuration
@Import({DataConfiguration.class, ServiceConfiguration.class})
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/index", "/home", "/static/**", "/WEB-INF/view/**").permitAll()
                        .requestMatchers("/login", "/api/**", "/register").anonymous()
                        .requestMatchers("/logout", "/profile").authenticated()
                        .requestMatchers("/add**", "/delete**", "/update**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .logout(Customizer.withDefaults())
        ;
        return http.build();
    }

    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {

        return new HandlerMappingIntrospector();
    }

}
