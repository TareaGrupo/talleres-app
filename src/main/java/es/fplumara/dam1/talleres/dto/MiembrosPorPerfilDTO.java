package es.fplumara.dam1.talleres.dto;

import es.fplumara.dam1.talleres.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MiembrosPorPerfilDTO {

    private List<Usuario> profesores= new ArrayList<>();
    private List<Usuario> alumnos = new ArrayList<>();
    private List<Usuario> invitados = new ArrayList<>();

    public MiembrosPorPerfilDTO(List<Usuario> profesores, List<Usuario> alumnos, List<Usuario> invitados) {
        this.profesores = profesores;
        this.alumnos = alumnos;
        this.invitados = invitados;
    }

    public List<Usuario> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Usuario> profesores) {
        this.profesores = profesores;
    }

    public List<Usuario> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Usuario> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Usuario> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Usuario> invitados) {
        this.invitados = invitados;
    }
}
