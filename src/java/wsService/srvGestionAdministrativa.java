package wsService;

import java.util.List;
import modelo.csGestionAdministrativa;
import dao.daoGestionAdministrativa;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "srvGestionAdministrativa")
public class srvGestionAdministrativa {

    private final daoGestionAdministrativa gestionDAO = new daoGestionAdministrativa();

    @WebMethod(operationName = "crearGestion")
    public String crearGestion(csGestionAdministrativa gestion) {
        try {
            gestionDAO.insertar(gestion);
            return "Gestión administrativa creada correctamente.";
        } catch (Exception e) {
            return "Error al crear gestión: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "obtenerGestiones")
    public List<csGestionAdministrativa> obtenerGestiones() {
        return gestionDAO.listar();
    }

    @WebMethod(operationName = "obtenerGestionPorId")
    public csGestionAdministrativa obtenerGestionPorId(int idGestion) {
        return gestionDAO.obtenerPorId(idGestion);
    }

    @WebMethod(operationName = "actualizarGestion")
    public String actualizarGestion(csGestionAdministrativa gestion) {
        try {
            gestionDAO.actualizar(gestion);
            return "Gestión administrativa actualizada correctamente.";
        } catch (Exception e) {
            return "Error al actualizar gestión: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "eliminarGestion")
    public String eliminarGestion(int idGestion) {
        try {
            gestionDAO.eliminar(idGestion);
            return "Gestión administrativa eliminada correctamente.";
        } catch (Exception e) {
            return "Error al eliminar gestión: " + e.getMessage();
        }
    }
}
