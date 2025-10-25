package wsService;

import java.util.List;
import modelo.csEmpleado;
import dao.daoEmpleado;
import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "srvEmpleado")
public class srvEmpleado {

    private final daoEmpleado empleadoDAO = new daoEmpleado();

    @WebMethod(operationName = "crearEmpleado")
    public String crearEmpleado(csEmpleado empleado) {
        try {
            empleadoDAO.insertar(empleado);
            return "Empleado creado correctamente.";
        } catch (Exception e) {
            return "Error al crear empleado: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "obtenerEmpleados")
    public List<csEmpleado> obtenerEmpleados() throws SQLException {
        return empleadoDAO.listar();
    }

    @WebMethod(operationName = "obtenerEmpleadoPorId")
    public csEmpleado obtenerEmpleadoPorId(int idEmpleado) throws SQLException {
        return empleadoDAO.obtenerPorId(idEmpleado);
    }

    @WebMethod(operationName = "actualizarEmpleado")
    public String actualizarEmpleado(csEmpleado empleado) {
        try {
            empleadoDAO.actualizar(empleado);
            return "Empleado actualizado correctamente.";
        } catch (Exception e) {
            return "Error al actualizar empleado: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "eliminarEmpleado")
    public String eliminarEmpleado(int idEmpleado) {
        try {
            empleadoDAO.eliminar(idEmpleado);
            return "Empleado eliminado correctamente.";
        } catch (Exception e) {
            return "Error al eliminar empleado: " + e.getMessage();
        }
    }
}
