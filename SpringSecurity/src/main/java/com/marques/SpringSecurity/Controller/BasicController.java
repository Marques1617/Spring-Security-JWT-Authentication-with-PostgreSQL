package com.marques.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController // Marca a classe como um controlador REST, devolvendo dados no corpo
public class BasicController {

    @GetMapping("/") // Quando alguém fizer uma requisição GET /hello, o Spring chamará
    // a função hello() e retornará "Hello, World!" no corpo da resposta.
    public String springSecurity(HttpServletRequest request) {
        return "Teste de Spring Security " + request.getSession().getId();
    }
}   
