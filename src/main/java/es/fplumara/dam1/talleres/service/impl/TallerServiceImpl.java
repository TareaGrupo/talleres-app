package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarTallerDTO;
import es.fplumara.dam1.talleres.dto.CrearTallerDTO;
import es.fplumara.dam1.talleres.exception.BusinessRuleException;
import es.fplumara.dam1.talleres.exception.DatosTallerException;
import es.fplumara.dam1.talleres.exception.NotFoundException;
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
        if (taller == null){
            throw new NotFoundException("no existe");
        }
    return taller;
    }

    @Override
    public Taller atualizarTaller(Long id, ActualizarTallerDTO dto) {
        Taller taller = tallerRepository.findById(id);
        if (taller == null) {
            throw new NotFoundException("no existe");
        }

        if (dto.getTitulo() != null){
            if (dto.getTitulo().trim().isEmpty()){
                throw new NotFoundException("El titulo no puede estar vacio");
            }
            taller.setTitulo(dto.getTitulo());

        }
        if (dto.getDescripcion() != null){
            taller.setDescripcion(dto.getDescripcion());
        }
        if (dto.getUrl() != null){
            taller.setUrl(dto.getUrl());
        }
        if (dto.getLugar() != null){
            taller.setLugar(dto.getLugar());
        }
        // if (dto.getCupo() != null){ FALTA CAMBIAR CUPO A INTERGER
        if (dto.getCupo() < 0){
                throw new BusinessRuleException("Ek cupo no puede ser negativo");
        }





        return null;
    }

    @Override
    public Taller cambiarEstadoTaller(Long id, EstadoInscripcion estadoInscripcion) {
        Taller taller = tallerRepository.findById(id);
        if (taller == null) {
            throw new NotFoundException("no existe");
        }
        taller.setEstadoInscripcion(estadoInscripcion);
        tallerRepository.save(taller);
        return taller;
    }

    @Override
    public void eliminarTaller(Long id) {
        Taller taller = tallerRepository.findById(id);
        if (taller == null) {
            throw new NotFoundException("no existe");
        }
        tallerRepository.deleteById(id);

    }
}
