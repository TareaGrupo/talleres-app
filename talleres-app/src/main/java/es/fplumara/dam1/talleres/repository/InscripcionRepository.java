package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.List;

public interface InscripcionRepository {

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);


}
