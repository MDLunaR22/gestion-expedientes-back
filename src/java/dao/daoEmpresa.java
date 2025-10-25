package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class daoEmpresa {
    public void crear(modelo.csEmpresa e) {
        String sql = "INSERT INTO Empresa(nombre, direccion, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getDireccion());
            stmt.setString(3, e.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<modelo.csEmpresa> listar() {
        List<modelo.csEmpresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM Empresa";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                empresas.add(new modelo.csEmpresa(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empresas;
    }

    public modelo.csEmpresa obtenerPorId(int id) {
        String sql = "SELECT * FROM Empresa WHERE id = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new modelo.csEmpresa(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void actualizar(modelo.csEmpresa e) {
        String sql = "UPDATE Empresa SET nombre=?, direccion=?, telefono=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getDireccion());
            stmt.setString(3, e.getTelefono());
            stmt.setInt(4, e.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Empresa WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
