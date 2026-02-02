package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryInscripcionRepository implements InscripcionRepository {

    private Map<String,Inscripcion> inscripciones;

    public InMemoryInscripcionRepository() {
        inscripciones = new HashMap<>();
    }

    @Override
    public Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        for (Inscripcion inscripcion : inscripciones.values()) {
            if (inscripcion.getUsuarioId().equals(usuarioId) && inscripcion.getTallerId().equals(tallerId)) {
                inscripciones.remove(inscripcion.getId());
            }
        }
        return null;
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

    @Override
    public Inscripcion Save(Inscripcion inscripcion) {
        if (inscripcion.getId() == null) {
            inscripcion.setId(inscripcion.getTallerId()+ "/" + inscripcion.getUsuarioId());


        }
        inscripciones.put(inscripcion.getId(), inscripcion);

        return inscripcion;
    }

    @Override
    public Inscripcion findById(String id) {
        for (Inscripcion inscripcion : inscripciones.values()){
            if (inscripcion.getId().equals(id));
            return inscripcion;
        }
        return null;
    }

    @Override
    public List<Inscripcion> findByTallerId(Long tallerId) {
        List<Inscripcion> salida = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones.values()){
            if (inscripcion.getTallerId().equals(tallerId));
            salida.add(inscripcion);
        }
        return salida;
    }

    @Override
    public List<Inscripcion> findbyUsuarioId(Long usuarioId) {
        List<Inscripcion> salida = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones.values()){
            if (inscripcion.getUsuarioId().equals(usuarioId)){
             salida.add(inscripcion);
            }
        }
        return salida;
    }

    @Override
    public Inscripcion deleteById(String id) {
       return inscripciones.remove(id);
    }

    @Override
    public List<Inscripcion> findByTallerIdAndRol(Long tallerId, String Rol) {
        //se podria cambiar a una lista este
        // metodo
        // para devolver listas de
        // coincidencias y no una sola coincidencia

        List<Inscripcion> salida = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones.values()) {
            if (inscripcion.getTallerId().equals(tallerId) && inscripcion.getRol().equals(Rol)) {
                salida.add(inscripcion);
            }
        }
        return salida;
    }
}
