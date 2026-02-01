package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.List;

public interface InscripcionRepository {

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

    Inscripcion Save (Inscripcion inscripcion);

    Inscripcion findById(String id);

    Inscripcion findByTallerId(Long tallerId);

    Inscripcion findbyUsuarioId(Long usuarioId);

    Inscripcion findByTallerIdAndRol(Long tallerId, String Rol);

    Inscripcion deleteById(String id);

    Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

}
