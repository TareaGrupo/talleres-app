package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

public interface InscripcionRepository {

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);
}
