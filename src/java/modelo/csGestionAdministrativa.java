package modelo;

public class csGestionAdministrativa {

    private int idGestion;
    private String nombre;
    private String descripcion;

    public csGestionAdministrativa() {
    }

    public csGestionAdministrativa(int idGestion, String nombre, String descripcion) {
        this.idGestion = idGestion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
