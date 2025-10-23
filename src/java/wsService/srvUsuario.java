package wsService;

import Estructura.csUsuarioM;
import Modelo.csUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvUsuario")
public class srvUsuario {

    private final csUsuario usuarioModel = new csUsuario();

    @WebMethod(operationName = "login")
    public boolean login(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "password") String password) {

        boolean valido = usuarioModel.login(usuario, password);
        return valido;
    }

    @WebMethod(operationName = "registrarUsuario")
    public String registrarUsuario(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "password") String password,
            @WebParam(name = "idEmpleado") Integer idEmpleado) {

        csUsuarioM nuevo = new csUsuarioM();
        nuevo.setUsuario(usuario);
        nuevo.setPassword(password);
        nuevo.setIdEmpleado(idEmpleado);

        boolean ok = usuarioModel.registrar(nuevo);
        return ok ? "Usuario registrado correctamente" : "Error al registrar el usuario";
    }
}