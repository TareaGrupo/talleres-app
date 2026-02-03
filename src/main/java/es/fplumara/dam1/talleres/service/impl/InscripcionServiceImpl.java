package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.exception.BusinessRuleException;
import es.fplumara.dam1.talleres.exception.NotFoundException;
import es.fplumara.dam1.talleres.model.Inscripcion;
import es.fplumara.dam1.talleres.model.Rol;
import es.fplumara.dam1.talleres.model.Taller;
import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.InscripcionService;

import java.util.List;

public class InscripcionServiceImpl implements InscripcionService {

    private InscripcionRepository inscripcionRepository;
    private TallerRepository tallerRepository;
    private UserRepository usuariorepository;

    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository, TallerRepository tallerRepository, UserRepository usuariorepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.tallerRepository = tallerRepository;
        this.usuariorepository = usuariorepository;
    }

    @Override
    public Inscripcion inscribirUsuario(Long tallerid, Long usuarioid, Rol rol) {
        Taller T = tallerRepository.findById(tallerid);
        Usuario u = usuariorepository.findById(usuarioid);
        if( T == null){
            throw new NotFoundException("Taller inexistente");
        }

        if( u == null){
            throw new NotFoundException("Usuario inexistente");
        }
        if (T.getEstadoInscripcion() != "ABIERTO"){
            throw new BusinessRuleException("No hay inscriociones abiertas");
        }


    }

    @Override
    public Inscripcion cambiarRol(Long tallerid, Long usuarioid) {
        return null;
    }

    @Override
    public Inscripcion expulsarUsuario(Long tallerid, Long usuarioid) {
        return null;
    }

    @Override
    public List<Inscripcion> listarInscripcionesDeTaller(Long tallerid) {
        if (TallerRepository.findById(tallerid) == null){
            throw new NotFoundException("El taller no existe");
        }

        return InscripcionRepository.findByTallerId(tallerid);
    }

    @Override
    public List<Inscripcion> listarInscripcionesDeUsuario(Long usuarioId) {
        return List.of();
    }

    @Override
    public List<Inscripcion> verMiembrosAgrupadosPorTaller(Long tallerid) {
        return List.of();
    }

    @Override
    public List<Inscripcion> verResponsables(Long tallerid) {
        return List.of();
    }
}

