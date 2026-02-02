package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarUsuarioDTO;
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.exception.BusinessRuleException;
import es.fplumara.dam1.talleres.exception.DatosUsuarioException;
import es.fplumara.dam1.talleres.exception.NotFoundException;
import es.fplumara.dam1.talleres.model.Inscripcion;
import es.fplumara.dam1.talleres.model.Perfil;
import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.UsuarioService;

import java.util.List;

public class UsuarioServiceimpl implements UsuarioService {

    private UserRepository userRepository;

    private InscripcionRepository inscripcionRepository;

    public UsuarioServiceimpl(UserRepository userRepository, InscripcionRepository inscripcionRepository) {
        this.userRepository = userRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Usuario crearUsuario(CrearUsuarioDTO crearUsuarioDTO) {
        if (crearUsuarioDTO.getNombre() == null || crearUsuarioDTO.getNombre().trim().isEmpty()){
            throw new DatosUsuarioException("Nombre requerido");
        }
        if (crearUsuarioDTO.getCurso() != null && crearUsuarioDTO.getPerfil() != Perfil.ALUMNO){
            throw new DatosUsuarioException("Solo los alumnos pueden tener curso");
        }
        if (crearUsuarioDTO.getEmail() != null){
            Usuario existente = userRepository.findByEmail(crearUsuarioDTO.getEmail());
            if (existente != null){
                throw new DatosUsuarioException("Email duplicado");
            }
        }
        if (crearUsuarioDTO.getDiscordUserId() != null){
            Usuario existente = userRepository.findByDiscordUserId(crearUsuarioDTO.getDiscordUserId());
            if (existente != null){
                throw new DatosUsuarioException("Discord duplicado");
            }

        }
        Usuario usuario = new Usuario();
        usuario.setNombre(crearUsuarioDTO.getNombre());
        usuario.setPerfil(crearUsuarioDTO.getPerfil());
        usuario.setCurso(crearUsuarioDTO.getCurso());
        usuario.setEmail(crearUsuarioDTO.getEmail());
        usuario.setDiscordUserId(crearUsuarioDTO.getDiscordUserId());
        return this.userRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {

        return userRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        Usuario usuario = userRepository.findById(id);

        if (usuario == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        return usuario;
    }

    @Override
    public Usuario actualizarUsuario(Long id, ActualizarUsuarioDTO cambiosUsuario) {
        Usuario usuario = userRepository.findById(id);
        if (usuario == null){
            throw new NotFoundException("Usuario no encontrado");
        }
        if (cambiosUsuario.getNombre() != null && !cambiosUsuario.getNombre().trim().isEmpty()) {
            usuario.setNombre(cambiosUsuario.getNombre());
        }

        if (cambiosUsuario.getPerfil() != null) {
            usuario.setPerfil(cambiosUsuario.getPerfil());
        }

        if (cambiosUsuario.getCurso() != null) {
            usuario.setCurso(cambiosUsuario.getCurso());
        }

        if (cambiosUsuario.getEmail() != null){
            Usuario otro = userRepository.findByEmail(cambiosUsuario.getEmail());
            if (otro != null && !otro.getId().equals(id)){
                throw new BusinessRuleException("Email duplicado");
            }
            usuario.setEmail(cambiosUsuario.getEmail());
        }
        if (cambiosUsuario.getDiscordUserId() != null){
            Usuario otro = userRepository.findByDiscordUserId(cambiosUsuario.getDiscordUserId());
            if (otro != null && !otro.getId().equals(id)){
                throw new BusinessRuleException("Discord duplicado");

            }
            usuario.setDiscordUserId(cambiosUsuario.getDiscordUserId());

        }
        if (usuario.getCurso() != null && usuario.getPerfil() != Perfil.ALUMNO){
            throw new BusinessRuleException("Solo los alumnos pueden tener curso asignado");
        }
        userRepository.save(usuario);

        return usuario;
    }

    @Override
    public Usuario borrarUsuario(Long usuarioId) {
        Usuario usuario = userRepository.findById(usuarioId);;
        if (usuario == null){
            throw new NotFoundException("No existe este usuario");

        }
        List<Inscripcion> inscripciones = inscripcionRepository.findbyUsuarioId(usuarioId);

        for (Inscripcion inscripcion : inscripciones){
            inscripcionRepository.deleteById(inscripcion.getId());
        }
        return usuario;

    }
}
