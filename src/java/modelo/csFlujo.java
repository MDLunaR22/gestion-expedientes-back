package modelo;

public class csFlujo {

    private int idFlujo;
    private int idExpediente;
    private int idDependencia;
    private int idGestion;
    private String estado;
    private String observaciones;

    public csFlujo() {
    }

    public csFlujo(int idFlujo, int idExpediente, int idDependencia, int idGestion, String estado, String observaciones) {
        this.idFlujo = idFlujo;
        this.idExpediente = idExpediente;
        this.idDependencia = idDependencia;
        this.idGestion = idGestion;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getIdFlujo() {
        return idFlujo;
    }

    public void setIdFlujo(int idFlujo) {
        this.idFlujo = idFlujo;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
