package com.gestion.productos.rest.repositorio;

import com.gestion.productos.rest.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
