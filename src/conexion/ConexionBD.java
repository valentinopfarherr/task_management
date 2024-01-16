package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:TareasDB.db";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa a la base de datos SQLite");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}