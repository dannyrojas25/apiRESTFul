package com.gestion.productos.rest.repositorio;

import com.gestion.productos.rest.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
