package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Taller;

import java.util.List;

public interface TallerRepository {

    Taller save(Taller taller);

    Taller findById(Long id);

    List<Taller> findAll();

    void deleteById(Long id);
}
