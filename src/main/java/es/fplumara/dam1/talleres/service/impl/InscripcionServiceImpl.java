package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.exception.BusinessRuleException;
import es.fplumara.dam1.talleres.exception.NotFoundException;
import es.fplumara.dam1.talleres.model.*;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.InscripcionService;

import java.util.List;
import java.util.Optional;

import static es.fplumara.dam1.talleres.model.EstadoInscripcion.ABIERTO;
import static es.fplumara.dam1.talleres.model.EstadoInscripcion.CERRADO;

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
        Inscripcion I = inscripcionRepository.findByTallerIdAndUsuarioId(tallerid, usuarioid);

        if (T == null) {
            throw new NotFoundException("Taller inexistente");
        }

        if (u == null) {
            throw new NotFoundException("Usuario inexistente");
        }
        if (T.getEstadoInscripcion() == CERRADO) {
            throw new BusinessRuleException("No hay inscriociones abiertas");
        }
        if (I != null) {
            throw new BusinessRuleException("el usuario ya esta inscrito en este taller");
        }
        if (rol == Rol.RESPONSABLE) {
            if (u.getPerfil() != Perfil.PROFESOR) {
                throw new BusinessRuleException("Debe ser profesor para ser responsable") {
                }
            }
        }
    }

    @Override
    public Inscripcion cambiarRol(Long tallerid, Long usuarioid) {
        return null;
    }

    @Override
    public Inscripcion expulsarUsuario(Long tallerid, Long usuarioid) {
        Inscripcion inscripcion = inscripcionRepository.findByTallerIdAndUsuarioId(tallerid, usuarioid);
        if (inscripcion == null) {
            throw new NotFoundException("La inscripcion no existe");
        }
    }

    @Override
    public List<Inscripcion> listarInscripcionesDeTaller(Long tallerid) {
        Optional<Taller> taller = TallerRepository.findById(tallerid);
        if( taller != null){
            throw new NotFoundException("EL taller no en encontrado");
        }
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

