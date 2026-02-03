package es.fplumara.dam1.talleres.service;


import es.fplumara.dam1.talleres.model.Inscripcion;
import es.fplumara.dam1.talleres.model.Rol;
;import java.util.List;

public interface InscripcionService {
    Inscripcion inscribirUsuario(Long tallerid, Long usuarioid, Rol rol);
    Inscripcion cambiarRol(Long tallerid, Long usuarioid);
    Inscripcion expulsarUsuario(Long tallerid, Long usuarioid);
    List<Inscripcion> listarInscripcionesDeTaller(Long tallerid);
    List<Inscripcion> listarInscripcionesDeUsuario(Long usuarioId);
    List<Inscripcion> verMiembrosAgrupadosPorTaller(Long tallerid);
    List<Inscripcion> verResponsables(Long tallerid);
}
