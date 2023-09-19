package com.gestion.productos.rest.controlador;

import com.gestion.productos.rest.modelo.Producto;
import com.gestion.productos.rest.servicio.ProductoServicio;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    private static final Logger logger = Logger.getLogger(ProductoControlador.class);
    {
        BasicConfigurator.configure();
    }

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        logger.debug("Listando produstos de la BD..");
        return productoServicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
        try {
            Producto producto = productoServicio.obtenerProductoPorId(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insertar-productos")
    public void guardarProducto(@Validated(Producto.class) @RequestBody Producto producto){
        productoServicio.guardarProducto(producto);
    }

    @PutMapping("/actualizar-producto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto, @Validated  @PathVariable Integer id){
        try {
            Producto productoActual = productoServicio.obtenerProductoPorId(id);

            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());

            productoServicio.guardarProducto(productoActual);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar-producto/{id}")
    public void eliminarProducto(@Validated @PathVariable Integer id){
        productoServicio.eliminarProducto(id);
    }
}
