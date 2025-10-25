package wsService;

import modelo.csUsuario;
import dao.daoUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvUsuario")
public class srvUsuario {

    private final daoUsuario usuarioDAO = new daoUsuario();

    @WebMethod(operationName = "login")
    public csUsuario login(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "password") String password) {

        csUsuario valido = usuarioDAO.login(usuario, password);
        return valido;
    }

    @WebMethod(operationName = "registrarUsuario")
    public String registrarUsuario(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "password") String password,
            @WebParam(name = "idEmpleado") Integer idEmpleado) {

        csUsuario nuevo = new csUsuario();
        nuevo.setUsuario(usuario);
        nuevo.setPassword(password);
        nuevo.setIdEmpleado(idEmpleado);

        boolean ok = usuarioDAO.registrar(nuevo);
        return ok ? "Usuario registrado correctamente" : "Error al registrar el usuario";
    }
}