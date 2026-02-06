package es.fplumara.dam1.talleres.service.impl;
import es.fplumara.dam1.talleres.dto.CrearTallerDTO;
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.exception.DatosUsuarioException;
import es.fplumara.dam1.talleres.model.Taller;
import es.fplumara.dam1.talleres.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)


public class TallerServiceImplTest {

    @Test
    public void crearTallerNombreVacio(){

        CrearTallerDTO taller = new CrearTallerDTO();
        taller.setTitulo(null);




    }





}
