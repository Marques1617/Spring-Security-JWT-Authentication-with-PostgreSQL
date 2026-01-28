
package com.marques.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController 
public class BasicController {

    @GetMapping("/") 
    public String springSecurity(HttpServletRequest request) {
        return "Teste de Spring Security " + request.getSession().getId(); //Session Id
    }
}   
