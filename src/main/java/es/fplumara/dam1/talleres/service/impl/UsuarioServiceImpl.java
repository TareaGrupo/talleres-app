package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.model.Inscripcion;
import es.fplumara.dam1.talleres.model.Perfil;
import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.UsuarioService;

import java.util.List;

import static sun.util.locale.LocaleUtils.isEmpty;

public class UsuarioServiceImpl implements UsuarioService {

    private UserRepository userRepository;
    private InscripcionRepository inscripcionRepository;

    public UsuarioServiceImpl(UserRepository userRepository, InscripcionRepository inscripcionRepository) {
        this.userRepository = userRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Usuario crearUsuario(CrearUsuarioDTO crearUsuarioDTO) {
        if (crearUsuarioDTO.getNombre() == null || crearUsuarioDTO.getNombre().isEmpty()) {
            throw new BusinessRuleException("Nombre no informado");
        }
        if (crearUsuarioDTO.getCurso() != null && !crearUsuarioDTO.getPerfil().equals(Perfil.ALUMNO)) {
            throw new BusinessRuleException("Solo los alumnos pueden estar en curso");
        }
        if (crearUsuarioDTO.getEmail() != null) {
            Usuario u = usuarioRepository.findByEmail(crearUsuarioDTO.getEmail());
            if (u != null) {
                throw new BusinessRuleException("El email ya existe");
            }
            if(crearUsuarioDTO.getDiscordUserId()!= null){
                Usuario U = usuarioRepository.findByDiscordUserId(crearUsuarioDTO.getDiscordUserId());
                if(u != null){
                    throw new BusinessRuleException("El usuario de discrod ya existe");
                }
            }
            Usuario nuevoUsuario = new Usuario(crearUsuarioDTO.getNombre(),crearUsuarioDTO.getPerfil(),crearUsuarioDTO.getDiscordUserId(),crearUsuarioDTO.getCurso(),crearUsuarioDTO.getEmail());
            Usuario usuarioCreado = usuarioRepositorio.save(nuevoUsuario);
            return usuarioCreado;
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public Usuario buscarUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if(usuario == null){
            throw new NotFoundException("Usuario no encontrado");
        }
        return null;
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario cambios) {
        Usuario original = userRepository.findById(id);

        if (original == null) {
            System.out.println("usuario no encontrado");
            return null;
        }
        if (cambios.getNombre() != null) original.setNombre(cambios.getNombre());
        if (cambios.getPerfil() != null) original.setPerfil(cambios.getPerfil());
        if (cambios.getCurso() != null) original.setCurso(cambios.getCurso());
        if (cambios.getEmail() != null) original.setEmail(cambios.getEmail());
        if (cambios.getDiscordUserId() != null) original.setDiscordUserId(cambios.getDiscordUserId());

        return userRepository.save(original);
    }


    @Override
    public void eliminarUsuario(Long id){
        Usuario u = userRepository.findById(id);
        if (u == null){
            System.out.println("Usuario no encontrado");
            return;
        }
        List<Inscripcion> inscripciones = inscripcionRepository.findBy UsuarioId(id);
        for (Inscripcion i : inscripciones){
            inscripcionRepository.deleteById(i.getId());
        }
        userRepository.deleteById(id);
        System.out.println("Usuario eliminado correctamente");
    }
}