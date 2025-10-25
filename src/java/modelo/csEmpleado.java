package modelo;

public class csEmpleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String puesto;
    private int idEmpresa;
    
    public csEmpleado(){
        
    }

    public csEmpleado(String nombre, String apellido, String puesto, int idEmpresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.idEmpresa = idEmpresa;
    }

    public csEmpleado(int idEmpleado, String nombre, String apellido, String puesto, int idEmpresa) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.idEmpresa = idEmpresa;
    }

    // Getters y Setters
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
}
