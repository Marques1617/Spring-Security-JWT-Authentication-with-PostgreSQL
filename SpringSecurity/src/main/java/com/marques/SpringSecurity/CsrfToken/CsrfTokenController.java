package com.marques.SpringSecurity.CsrfToken;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CsrfTokenController {

    // Retorna o token CSRF necessário para POST, PUT, DELETE
    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
