package modelo;

public class csDependencia {

    private int idDependencia;
    private String nombre;
    private String descripcion;
    private int idEmpresa;

    public csDependencia() {
    }

    public csDependencia(int idDependencia, String nombre, String descripcion, int idEmpresa) {
        this.idDependencia = idDependencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idEmpresa = idEmpresa;
    }

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
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

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
