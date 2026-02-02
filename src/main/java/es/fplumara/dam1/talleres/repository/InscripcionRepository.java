package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

public interface InscripcionRepository {

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);
    Inscripcion save (Inscripcion inscripcion);
    Inscripcion findById (String id);
    Inscripcion findeByTallerId(Long TallerId);
    Inscripcion findUsuario(Long UsuarioId);
    Inscripcion FindByTallerIdAndRol(Long TallerId, String Rol);
    Inscripcion deleteById(String id);
    Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuario);
}
