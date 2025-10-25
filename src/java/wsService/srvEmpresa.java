package wsService;

import dao.daoEmpresa;
import modelo.csEmpresa;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "srvEmpresa")
public class srvEmpresa {
    
    daoEmpresa empresaDAO = new daoEmpresa();

    @WebMethod(operationName = "crearEmpresa")
    public String crearEmpresa(String nombre, String direccion, String telefono, String email) {
        return empresaDAO.crear(new csEmpresa(nombre, direccion, telefono, email));
    }

    @WebMethod(operationName = "listarEmpresas")
    public List<csEmpresa> listarEmpresas() {
        return empresaDAO.listar();
    }

    @WebMethod(operationName = "obtenerEmpresa")
    public csEmpresa obtenerEmpresa(int id) {
        return empresaDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "actualizarEmpresa")
    public String actualizarEmpresa(int id, String nombre, String direccion, String telefono, String email) {
        return empresaDAO.actualizar(new csEmpresa(id, nombre, direccion, telefono, email));
    }

    @WebMethod(operationName = "eliminarEmpresa")
    public String eliminarEmpresa(int id) {
        return empresaDAO.eliminar(id);
    }
}
