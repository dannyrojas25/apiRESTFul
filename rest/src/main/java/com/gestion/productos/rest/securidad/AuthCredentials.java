package com.gestion.productos.rest.securidad;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
