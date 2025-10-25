package dao;

import dao.Conexion;
import modelo.csDependencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoDependencia {

    public void insertar(csDependencia d) throws SQLException {
        String sql = "INSERT INTO dependencia (nombre, descripcion, idEmpresa) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getDescripcion());
            ps.setInt(3, d.getIdEmpresa());
            ps.executeUpdate();
        }
    }

    public List<csDependencia> listar() {
        List<csDependencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM dependencia";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new csDependencia(
                        rs.getInt("idDependencia"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("idEmpresa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public csDependencia obtenerPorId(int id) {
        csDependencia d = null;
        String sql = "SELECT * FROM dependencia WHERE idDependencia = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d = new csDependencia(
                        rs.getInt("idDependencia"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("idEmpresa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void actualizar(csDependencia d) throws SQLException {
        String sql = "UPDATE dependencia SET nombre = ?, descripcion = ?, idEmpresa = ? WHERE idDependencia = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getDescripcion());
            ps.setInt(3, d.getIdEmpresa());
            ps.setInt(4, d.getIdDependencia());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM dependencia WHERE idDependencia = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
