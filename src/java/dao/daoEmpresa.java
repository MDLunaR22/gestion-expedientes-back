package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class daoEmpresa {
    public String crear(modelo.csEmpresa e) {
        String sql = "INSERT INTO Empresa(nombre, direccion, telefono, email) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getDireccion());
            stmt.setString(3, e.getTelefono());
            stmt.executeUpdate();
            return "Empresa creada con exito";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Se obtuvo un error al crear la empresa " + ex.getMessage();
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
                    rs.getInt("idEmpresa"),
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
        String sql = "SELECT * FROM Empresa WHERE idEmpresa = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new modelo.csEmpresa(
                    rs.getInt("idEmpresa"),
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

    public String actualizar(modelo.csEmpresa e) {
        String sql = "UPDATE Empresa SET nombre=?, direccion=?, telefono=?, email=? WHERE idEmpresa=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getDireccion());
            stmt.setString(3, e.getTelefono());
            stmt.setString(4, e.getEmail());
            stmt.setInt(5, e.getId());
            stmt.executeUpdate();
            return "Empresa actualizada con exito";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Hubo un problema al actualizar la Empresa" + ex.getMessage();
        }
    }

    public String eliminar(int id) {
        String sql = "DELETE FROM Empresa WHERE idEmpresa=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "Empresa eliminada con exito";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Hubo un problema al actualizar la Empresa " + ex.getMessage();
        }
    }
}
