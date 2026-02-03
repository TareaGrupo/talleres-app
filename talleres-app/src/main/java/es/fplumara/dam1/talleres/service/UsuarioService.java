package es.fplumara.dam1.talleres.service;

import es.fplumara.dam1.talleres.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario buscarUsuario(Long id);

    Usuario actualizarUsuario(Long id, Usuario cambios);

    void eliminarUsuario(Long id);
}
