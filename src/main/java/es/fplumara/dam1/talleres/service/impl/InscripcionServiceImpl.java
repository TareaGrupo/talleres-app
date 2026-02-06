package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.MiembrosPorPerfilDTO;
import es.fplumara.dam1.talleres.exception.NotFoundException;
import es.fplumara.dam1.talleres.model.*;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.InscripcionService;

import java.util.List;

public class InscripcionServiceImpl implements InscripcionService {
    private InscripcionRepository InscripcionRepository;

    private UserRepository UseRepository;

    private TallerRepository TallerRepository;

    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository, TallerRepository tallerRepository, UserRepository useRepository) {
        this.InscripcionRepository = inscripcionRepository;
        this.TallerRepository = tallerRepository;
        this.UseRepository = useRepository;
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
        if (UseRepository.findById(usuarioId) == null){
            throw new NotFoundException("El usuario no existe");
        }
        return InscripcionRepository.findbyUsuarioId(usuarioId);
    }

    @Override
    public MiembrosPorPerfilDTO verMiembrosAgrupadosPorTaller(Long tallerid) {
        if (TallerRepository.findById(tallerid) == null){
            throw new NotFoundException("Taller no existe");
        }
        List<Inscripcion> inscripciones = InscripcionRepository.findByTallerId(tallerid);





            return ;
    }

    @Override
    public Inscripcion inscribirUsuario(Long tallerid, Long usuarioid, Rol rol) {
        return null;
    }

    @Override
    public List<Inscripcion> verResponsables(Long tallerid) {
        return List.of();
    }

    @Override
    public Inscripcion cambiarRol(Long tallerid, Long usuarioid) {
        return null;
    }

    @Override
    public Inscripcion expulsarUsuario(Long tallerid, Long usuarioid) {
        return null;
    }
}
