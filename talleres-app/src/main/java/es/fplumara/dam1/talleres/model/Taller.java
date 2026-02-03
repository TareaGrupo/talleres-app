package es.fplumara.dam1.talleres.model;

public class Taller {

    private Long id;
    private String titulo;
    private String descripcion;
    private EstadoInscripcion estadoInscripcion;
    private String url;
    private String lugar;

    private int cupo;

    public Taller(){

    }
    public Taller(String titulo, String descripcion, EstadoInscripcion estadoInscripcion, String url, String lugar, int cupo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.url = url;
        this.lugar = lugar;
        this.cupo = cupo;
    }


    public Taller(Long id, String titulo, String descripcion, EstadoInscripcion estadoInscripcion, String url, String lugar, int cupo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.url = url;
        this.lugar = lugar;
        this.cupo = cupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoInscripcion getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(EstadoInscripcion estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
