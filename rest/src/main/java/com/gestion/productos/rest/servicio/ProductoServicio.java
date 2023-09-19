package com.gestion.productos.rest.servicio;

import com.gestion.productos.rest.modelo.Producto;
import com.gestion.productos.rest.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    public void guardarProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    public Producto obtenerProductoPorId(Integer id){
        return productoRepositorio.findById(id).get();
    }

    public void eliminarProducto(Integer id){
        productoRepositorio.deleteAllById(Collections.singleton(id));
    }
}
