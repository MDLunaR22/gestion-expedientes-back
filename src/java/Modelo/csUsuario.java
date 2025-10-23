package Modelo;

import Estructura.csUsuarioM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class csUsuario {

    // 🔹 LOGIN
    public boolean login(String usuario, String password) {
        String sql = "SELECT idUsuario, usuario, [password], idEmpleado " +
                     "FROM Usuario WHERE usuario=? AND [password]=?";
        try (Connection c = csConexion.getConnection();
             PreparedStatement st = c.prepareStatement(sql)) {

            st.setString(1, usuario);
            st.setString(2, password);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    csUsuarioM u = new csUsuarioM();
                    u.setIdUsuario(rs.getInt("idUsuario"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setPassword(rs.getString("password")); // mapeado desde [password]
                    u.setIdEmpleado(rs.getInt("idEmpleado"));
                    return true;
                }
            }
        } catch (SQLException e) {
            // Propaga para que el servicio cree un SOAPFault claro
            throw new RuntimeException("DB login error: " + e.getMessage(), e);
        }
        return false;
    }

    // 🔹 REGISTRO
    public boolean registrar(csUsuarioM usuario) {
        String sql = "INSERT INTO Usuario (usuario, password, idEmpleado) VALUES (?, ?, ?)";
        try (Connection conn = csConexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());

            if (usuario.getIdEmpleado() != null) {
                ps.setInt(3, usuario.getIdEmpleado());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
