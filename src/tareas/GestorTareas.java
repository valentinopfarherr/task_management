package tareas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;

public class GestorTareas {

    public void agregarTarea(int usuarioId, String descripcion) {
        String sql = "INSERT INTO tareas (usuario_id, descripcion, estado) VALUES (?, ?, 'NO RESUELTO')";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Tarea agregada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al agregar la tarea: " + e.getMessage());
        }
    }

    public void obtenerTareasUsuario(int usuarioId) {
        String sql = "SELECT * FROM tareas WHERE usuario_id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");
                System.out.println("ID: " + id + ", Descripción: " + descripcion + ", Estado: " + estado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las tareas del usuario: " + e.getMessage());
        }
    }
}