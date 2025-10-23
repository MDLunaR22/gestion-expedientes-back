package Estructura;

public class csUsuarioM {
    private int idUsuario;
    private String usuario;
    private String password;
    private Integer idEmpleado; // Puede ser null

    public csUsuarioM() {
    }

    public csUsuarioM(int idUsuario, String usuario, String password, Integer idEmpleado) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.idEmpleado = idEmpleado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Usuario { " +
                "idUsuario=" + idUsuario +
                ", usuario='" + usuario + '\'' +
                ", idEmpleado=" + idEmpleado +
                " }";
    }
}
