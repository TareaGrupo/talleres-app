package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

public interface InscripcionRepository {

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);
    Inscripcion save (Inscripcion inscripcion);
    Inscripcion findById (String id);
    Inscripcion findByTallerId(Long TallerId);
    Inscripcion findUsuario(Long UsuarioId);
    Inscripcion findByTallerIdAndRol(Long TallerId, String Rol);
    Inscripcion deleteById(String id);
    Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuario);
}
