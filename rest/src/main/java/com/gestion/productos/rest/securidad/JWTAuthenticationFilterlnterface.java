package com.gestion.productos.rest.securidad;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

public interface JWTAuthenticationFilterlnterface {
    Authentication attempAuthentication(HttpServletRequest request,
                                        HttpServletResponse response) throws AuthenticationException;

    void succesFulAuthentication(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain chain,
                                 Authentication authResult) throws IOException, ServletException;
}
