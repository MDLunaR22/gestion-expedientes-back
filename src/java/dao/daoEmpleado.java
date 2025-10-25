package dao;

import modelo.csEmpleado;
import java.sql.*;
import java.util.*;

public class daoEmpleado {

    public List<csEmpleado> listar() {
        List<csEmpleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                csEmpleado e = new csEmpleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setPuesto(rs.getString("puesto"));
                e.setIdEmpresa(rs.getInt("idEmpresa"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return lista;
    }

    public boolean insertar(csEmpleado e) {
        String sql = "INSERT INTO empleado(nombre, apellido, puesto, idEmpresa) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getPuesto());
            ps.setInt(4, e.getIdEmpresa());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.getStackTrace();
            return false;
        } 
    }

    public boolean actualizar(csEmpleado e) {
        String sql = "UPDATE empleado SET nombre=?, apellido=?, puesto=?, idEmpresa=? WHERE idEmpleado=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getPuesto());
            ps.setInt(4, e.getIdEmpresa());
            ps.setInt(5, e.getIdEmpleado());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id){
        String sql = "DELETE FROM empleado WHERE idEmpleado=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public csEmpleado obtenerPorId(int id) {
        String sql = "SELECT * FROM empleado WHERE idEmpleado=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                csEmpleado e = new csEmpleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setPuesto(rs.getString("puesto"));
                e.setIdEmpresa(rs.getInt("idEmpresa"));
                return e;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
