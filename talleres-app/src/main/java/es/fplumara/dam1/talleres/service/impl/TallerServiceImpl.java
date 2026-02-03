package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarTallerDTO;
import es.fplumara.dam1.talleres.dto.CrearTallerDTO;
import es.fplumara.dam1.talleres.exception.DatosTallerException;
import es.fplumara.dam1.talleres.model.EstadoInscripcion;
import es.fplumara.dam1.talleres.model.Taller;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.service.TallerService;

import java.util.List;

public class TallerServiceImpl implements TallerService {

    private TallerRepository tallerRepository;


    TallerServiceImpl(TallerRepository tallerRepository) {
        this.tallerRepository = tallerRepository;
    }

    @Override
    public Taller createTaller(CrearTallerDTO crearTallerDTO) {
        if(crearTallerDTO.getTitulo() == null){
            throw new DatosTallerException("titulo requerido");
        }
        if (crearTallerDTO.getDescripcion() == null){
            throw new DatosTallerException("descripcion requerida");
        }
        Taller taller = new Taller();
        taller.setTitulo(crearTallerDTO.getTitulo());
        taller.setDescripcion(crearTallerDTO.getDescripcion());
        taller.setUrl(crearTallerDTO.getUrl());
        taller.setLugar(crearTallerDTO.getLugar());
        taller.setCupo(crearTallerDTO.getCupo());
        taller.setEstadoInscripcion(EstadoInscripcion.CERRADO);

        return this.tallerRepository.save(taller);
    }

    @Override
    public List<Taller> listarTalleres() {
        return tallerRepository.findAll();
    }

    @Override
    public Taller obtenerTaller(Long id) {
        Taller taller = tallerRepository.findById(id);
        if(taller == null){
            throw new DatosTallerException("Taller no encontrado");
        }
        return  taller;
    }

    @Override
    public Taller atualizarTaller(Long id, ActualizarTallerDTO dto) {
        Taller taller = tallerRepository.findById(id);
        if (taller == null) {
            throw new DatosTallerException("Taller no encontrado");
        }
        if (dto.getTitulo() != null) {
            if (dto.getTitulo().isBlank()) {
                throw new DatosTallerException("El titulo no puede estar vacio");
            }
            taller.setTitulo(dto.getTitulo());
        }
        if (dto.getDescripcion() != null) {
            taller.setDescripcion(dto.getDescripcion());
        }
        if (dto.getUrl() != null) {
            taller.setUrl(dto.getUrl());
        }
        if (dto.getLugar() != null) {
            taller.setLugar(dto.getLugar());
        }
        if (dto.getCupo() != null) {
            if (dto.getCupo() < 0) {
                throw new DatosTallerException("El cupo no puede ser negativo");
            }
            taller.setCupo(dto.getCupo());
        }
        return tallerRepository.save(taller);
    }

    @Override
    public Taller cambiarEstadoTaller(Long id, EstadoInscripcion estadoInscripcion) {
        Taller taller = tallerRepository.findById(id);
        if(taller == null){
            throw new DatosTallerException("Taller no encontrado");
        }
        taller.setEstadoInscripcion(estadoInscripcion);
        return tallerRepository.save(taller);
    }

    @Override
    public void eliminarTaller(Long id) {
        Taller taller = tallerRepository.findById(id);
        if(taller == null) {
            throw new DatosTallerException("Taller no encontrado");
        }
        tallerRepository.deleteById(id);
    }
}
