package es.fplumara.dam1.talleres.service;

import es.fplumara.dam1.talleres.dto.ActualizarUsuarioDTO;
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.model.Perfil;
import es.fplumara.dam1.talleres.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(CrearUsuarioDTO crearUsuarioDTO);

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuario(Long id);

    Usuario actualizarUsuario(Long id, ActualizarUsuarioDTO cambiosUsuario);

    Usuario borrarUsuario(Long id);
}
