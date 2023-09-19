package com.gestion.productos.rest.controlador;

import com.gestion.productos.rest.modelo.Usuario;
import com.gestion.productos.rest.servicio.UsuarioServicio;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControlador {

    private static final Logger logger = Logger.getLogger(UsuarioControlador.class);
    {
        BasicConfigurator.configure();
    }

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        logger.debug("Listando usuarios de la BD..");
        return usuarioServicio.listarUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerusuarios(@PathVariable Integer id){
        try {
            Usuario usuario = usuarioServicio.obtenerUsuarioPorId(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insertar-usuario")
    public void guardarUsuario(@Validated(Usuario.class) @RequestBody Usuario usuario){
        usuarioServicio.guardarUsuario(usuario);
    }

    @PutMapping("/actualizar-usuario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario, @Validated  @PathVariable Integer id){
        try {
            Usuario usuarioActual = usuarioServicio.obtenerUsuarioPorId(id);

            usuarioActual.setNombreCompleto(usuario.getNombreCompleto());
            usuarioActual.setEdad(usuario.getEdad());
            usuarioActual.setDireccion(usuario.getDireccion());
            usuarioActual.setNumeroIdentificacion(usuario.getNumeroIdentificacion());

            usuarioServicio.guardarUsuario(usuarioActual);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar-usuario/{id}")
    public void eliminarUsuario(@Validated @PathVariable Integer id){
        usuarioServicio.eliminarUsuario(id);
    }
}
