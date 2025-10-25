package wsService;

import modelo.csEmpresa;
import dao.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "srvEmpresa")
public class srvEmpresa {

    @WebMethod(operationName = "crearEmpresa")
    public String crearEmpresa(String nombre, String direccion, String telefono, String email) {
        String sql = "INSERT INTO Empresa (nombre, direccion, telefono, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.executeUpdate();
            return "Empresa creada con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al crear empresa: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "listarEmpresas")
    public List<csEmpresa> listarEmpresas() {
        List<csEmpresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                csEmpresa e = new csEmpresa();
                e.setId(rs.getInt("idEmpresa"));
                e.setNombre(rs.getString("nombre"));
                e.setDireccion(rs.getString("direccion"));
                e.setTelefono(rs.getString("telefono"));
                e.setEmail(rs.getString("email"));
                lista.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @WebMethod(operationName = "obtenerEmpresa")
    public csEmpresa obtenerEmpresa(int id) {
        csEmpresa emp = null;
        String sql = "SELECT * FROM Empresa WHERE idEmpresa = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new csEmpresa();
                emp.setId(rs.getInt("idEmpresa"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @WebMethod(operationName = "actualizarEmpresa")
    public String actualizarEmpresa(int id, String nombre, String direccion, String telefono, String email) {
        String sql = "UPDATE Empresa SET nombre=?, direccion=?, telefono=?, email=? WHERE idEmpresa=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.setInt(5, id);
            ps.executeUpdate();
            return "Empresa actualizada correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar empresa: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "eliminarEmpresa")
    public String eliminarEmpresa(int id) {
        String sql = "DELETE FROM Empresa WHERE idEmpresa=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return "Empresa eliminada correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar empresa: " + e.getMessage();
        }
    }
}
