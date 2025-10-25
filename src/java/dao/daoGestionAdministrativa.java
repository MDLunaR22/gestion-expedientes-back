package dao;

import dao.Conexion;
import modelo.csGestionAdministrativa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoGestionAdministrativa {

    public boolean insertar(csGestionAdministrativa g) throws SQLException {
        String sql = "INSERT INTO gestionadministrativa (nombre, descripcion) VALUES (?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, g.getNombre());
            ps.setString(2, g.getDescripcion());
            ps.executeUpdate();
            return true;
        }
    }

    public List<csGestionAdministrativa> listar() {
        List<csGestionAdministrativa> lista = new ArrayList<>();
        String sql = "SELECT * FROM gestionadministrativa";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new csGestionAdministrativa(
                        rs.getInt("idGestion"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public csGestionAdministrativa obtenerPorId(int id) {
        csGestionAdministrativa g = null;
        String sql = "SELECT * FROM gestionadministrativa WHERE idGestion = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                g = new csGestionAdministrativa(
                        rs.getInt("idGestion"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    public void actualizar(csGestionAdministrativa g) throws SQLException {
        String sql = "UPDATE gestionadministrativa SET nombre = ?, descripcion = ? WHERE idGestion = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, g.getNombre());
            ps.setString(2, g.getDescripcion());
            ps.setInt(3, g.getIdGestion());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM gestionadministrativa WHERE idGestion = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
