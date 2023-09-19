package com.gestion.productos.rest.servicio;

import com.gestion.productos.rest.modelo.Usuario;
import com.gestion.productos.rest.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Integer id){
        return usuarioRepositorio.findById(id).get();
    }

    public void eliminarUsuario(Integer id){
        usuarioRepositorio.deleteAllById(Collections.singleton(id));
    }
}
