package com.marques.SpringSecurity.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.marques.SpringSecurity.Config.Filter.JwtFilter;

@Configuration // -> (Tells spring that this is a class of Configuration)
@EnableWebSecurity //-> (Tells the spring that this class provides Spring Security configuration and enables customization of the security behavior according to the developer’s requirements)
// For example, it allows the use of specific security configuration objects, such as SecurityFilterChain
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean // Define um bean gerenciado pelo Spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
            .csrf(customizer -> customizer.disable()) // Desabilita a proteção CSRF (não recomendado para produção)
            .authorizeHttpRequests(request -> request
                .requestMatchers("register", "login")// Permite acesso sem autenticação aos endpoints /register e /login  
                .permitAll() // Permite acesso sem autenticação ao endpoint /register e /login
                .anyRequest().authenticated()) // Exige autenticação para todas as requisições
            .httpBasic(Customizer.withDefaults()) // Habilita a autenticação HTTP Basic (Postman)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura a política de criação de sessão como STATELESS (sem estado)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)// Faz primeiro o JwtFilter e depois o UserPassAuthFilter
            .build();
    }

    @Bean //Create an AuthenticationProvider
    public AuthenticationProvider authenticationProvider() { // It receives an Un-authenticated Object (e.g.login,register),it verifies the credentials to see if they are valid 
        //if valid, it returns an authenticated Authentication object with authorities.”
        
        //needs to connect to the database, to get the data
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); //The password in the database is hashed so we need to hash the password that the user is providing
        // to compare the two passwords. So the authentication provider knows how manage tha password to compara between the two (login form and the database )
        provider.setUserDetailsService(userDetailsService); //My own UserDetailedService (i create the MyUserDetailsService)
        return provider; 
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    
}
 