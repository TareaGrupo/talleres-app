package es.fplumara.dam1.talleres.dto;

import es.fplumara.dam1.talleres.model.Perfil;

public class CrearUsuarioDTO {
    private Perfil perfil;

    private String nombre;

    private String discordUserId;

    private String curso;

    private String email;

    public CrearUsuarioDTO(Perfil perfil, String email, String curso, String discordUserId, String nombre) {
        this.perfil = perfil;
        this.email = email;
        this.curso = curso;
        this.discordUserId = discordUserId;
        this.nombre = nombre;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDiscordUserId() {
        return discordUserId;
    }

    public void setDiscordUserId(String discordUserId) {
        this.discordUserId = discordUserId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
