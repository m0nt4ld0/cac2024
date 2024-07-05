package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {
    
    public static Connection abrirConexion() {
        //TPH: Investigar cómo conectarnos
        String db="peliculas";
        // Usuario BDD
        String user = "root";
        // Contraseña BDD
        String password = "toor";
        // Connection String
        String url = "jdbc:mysql://localhost:3306/" + db + "?useSSL=false&serverTimezone=UTC";
        String driver ="com.mysql.cj.jdbc.Driver";
        // le quito el this porque hago el metodo estatico this.conn = null;
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            conn = null;
        }
        return conn;
    }

    public static void cerrarConexion(Connection conn) {
        try {
            if (conn != null) {
                System.out.println("Cerrando conexión a la base de datos...");
                conn.close();
            }
            else {
                System.out.println("No hay ninguna conexión a la BD para cerrar. Cancelando.");
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexion.");
            e.printStackTrace();
        }
    }
}
