package dao;

import dao.Conexion;
import modelo.csFlujo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoFlujo {

    public void insertar(csFlujo f) throws SQLException {
        String sql = "INSERT INTO flujo (idExpediente, idDependencia, idGestion, estado, observaciones) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, f.getIdExpediente());
            ps.setInt(2, f.getIdDependencia());
            ps.setInt(3, f.getIdGestion());
            ps.setString(4, f.getEstado());
            ps.setString(5, f.getObservaciones());
            ps.executeUpdate();
        }
    }

    public List<csFlujo> listar() {
        List<csFlujo> lista = new ArrayList<>();
        String sql = "SELECT * FROM flujo";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new csFlujo(
                        rs.getInt("idFlujo"),
                        rs.getInt("idExpediente"),
                        rs.getInt("idDependencia"),
                        rs.getInt("idGestion"),
                        rs.getString("estado"),
                        rs.getString("observaciones")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminar(int idFlujo) throws SQLException {
        String sql = "DELETE FROM flujo WHERE idFlujo = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idFlujo);
            ps.executeUpdate();
        }
    }
}
