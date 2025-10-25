package wsService;

import java.util.List;
import modelo.csDependencia;
import dao.daoDependencia;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "srvDependencia")
public class srvDependencia {

    private final daoDependencia dependenciaDAO = new daoDependencia();

    @WebMethod(operationName = "crearDependencia")
    public String crearDependencia(csDependencia dependencia) {
        try {
            dependenciaDAO.insertar(dependencia);
            return "Dependencia creada correctamente.";
        } catch (Exception e) {
            return "Error al crear dependencia: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "obtenerDependencias")
    public List<csDependencia> obtenerDependencias() {
        return dependenciaDAO.listar();
    }

    @WebMethod(operationName = "obtenerDependenciaPorId")
    public csDependencia obtenerDependenciaPorId(int idDependencia) {
        return dependenciaDAO.obtenerPorId(idDependencia);
    }

    @WebMethod(operationName = "actualizarDependencia")
    public String actualizarDependencia(csDependencia dependencia) {
        try {
            dependenciaDAO.actualizar(dependencia);
            return "Dependencia actualizada correctamente.";
        } catch (Exception e) {
            return "Error al actualizar dependencia: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "eliminarDependencia")
    public String eliminarDependencia(int idDependencia) {
        try {
            dependenciaDAO.eliminar(idDependencia);
            return "Dependencia eliminada correctamente.";
        } catch (Exception e) {
            return "Error al eliminar dependencia: " + e.getMessage();
        }
    }
}
