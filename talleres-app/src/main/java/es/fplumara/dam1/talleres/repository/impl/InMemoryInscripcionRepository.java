package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInscripcionRepository implements InscripcionRepository {

    private Map<String,Inscripcion> inscripciones;

    public InMemoryInscripcionRepository() {
        inscripciones = new HashMap<>();
    }

    @Override
    public Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        /**
        String inscripcionId = tallerId.toString()+"/"+usuarioId.toString();
        return inscripciones.get(inscripcionId);
         **/
        for (Inscripcion inscripcion : inscripciones.values()) {
            if (inscripcion.getUsuarioId().equals(usuarioId) && inscripcion.getTallerId().equals(tallerId)) {
                return inscripcion;
            }
        }
        return null;

    }
}
