package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UsuariosDTO;
import web.Usuarios;

// La clase nos dice el cómo

public class UsuariosDAOMySQLImpl implements UsuariosDAO {
    
    public Usuarios getUsuarioById(Long id) {
        Connection cnx = null;
        Usuarios u = null;
        // TPH: Averiguar como parametrizar la consulta con el ?
        String sql = "SELECT id_usuario, nombre, apellido, email, contraseña, fecha_nac, "
        + "pais FROM usuarios WHERE id_usuario = " + id;
        try {
            // 1) Conectarme a la DB
            cnx = AdministradorDeConexiones.abrirConexion();
            PreparedStatement pstmt = cnx.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            // Leer el ResultSet y crear mis entidades
            // Si hay datos, solo tengo un registro porque estoy preguntando con id
            if(rs.next()) {
                Long idUsuario = (long) rs.getInt(1);
                String nombreUsuario = rs.getString(2);
                String apeUsuario = rs.getString(3);
                String mailUsuario = rs.getString(4);
                String pwdUsuario = rs.getString(5);
                Date fnacUsuario = rs.getDate(6);
                String paisUsuario = rs.getString(7);
                u = new Usuarios(idUsuario, nombreUsuario, apeUsuario, mailUsuario, pwdUsuario, fnacUsuario, paisUsuario);
            }
        } catch(Exception e ) {
            System.err.println("Error al recuperar datos del usuario.");
        } finally {
            AdministradorDeConexiones.cerrarConexion(cnx);
        }
        return u;
    }

    public void deleteUsuarioById(Long id) {
        Connection cnx = null;
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try {
            // 1) Conectarme a la DB
            cnx = AdministradorDeConexiones.abrirConexion();
            PreparedStatement pstmt = cnx.prepareStatement(sql);
            pstmt.setLong(1, id);
            if(pstmt.executeUpdate() > 0)
                System.out.println("El usuario con ID = " + id + " ha sido eliminado.");
        } catch(Exception e ) {
            System.err.println("Error al eliminar el usuario.");
        } finally {
            AdministradorDeConexiones.cerrarConexion(cnx);
        }
    }

    public void crearUsuario(UsuariosDTO u) {
        // Uso el administrador de conexiones
        Connection cnx = null;
        // Consulta SQL parametrizada
        String sql = "INSERT INTO usuarios (nombre, apellido, email, contraseña"
            + ", pais) VALUES (?, ?, ?, ?, ?)";

        try {
            cnx = AdministradorDeConexiones.abrirConexion();
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            // Establecer los valores de los parámetros
            preparedStatement.setString(1, u.getNombreUsuario());
            preparedStatement.setString(2, u.getApeUsuario());
            preparedStatement.setString(3, u.getMailUsuario());
            preparedStatement.setString(4, u.getPwdUsuario());
            //preparedStatement.setDate(5, u.getFnacUsuario());
            preparedStatement.setString(5, u.getPaisUsuario());

            // Ejecutar la inserción
            if(preparedStatement.executeUpdate() > 0) {
                // Confirmar el número de filas afectadas
                System.out.println("Se insertó el usuario: " + u.getNombreUsuario() + " " + u.getApeUsuario());
            };

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.cerrarConexion(cnx);
        }
    }
    
    public void editarUsuario(UsuariosDTO u) {
        // Uso el administrador de conexiones
        Connection cnx = null;
        // Consulta SQL parametrizada
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, contraseña = ?"
            + ", pais = ? WHERE id_usuario = ?";

        try {
            cnx = AdministradorDeConexiones.abrirConexion();
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            // Establecer los valores de los parámetros
            preparedStatement.setString(1, u.getNombreUsuario());
            preparedStatement.setString(2, u.getApeUsuario());
            preparedStatement.setString(3, u.getMailUsuario());
            preparedStatement.setString(4, u.getPwdUsuario());
            //preparedStatement.setDate(5, u.getFnacUsuario());
            preparedStatement.setString(5, u.getPaisUsuario());
            preparedStatement.setLong(6, u.getIdUsuario());

            // Ejecutar la actualización
            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Se actualizó el usuario: " + u.getNombreUsuario() + " " + u.getApeUsuario());
            };

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.cerrarConexion(cnx);
        }
    }

    public ArrayList<UsuariosDTO> findAll() {
        String sql = "select id_usuario, nombre, apellido, email, contraseña, fecha_nac, pais from usuarios LIMIT 10";
        ArrayList<UsuariosDTO> usrs = new ArrayList<>();
        Connection con = null;
        try{
            con = AdministradorDeConexiones.abrirConexion();
            PreparedStatement  statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Long idUsuario = resultSet.getLong(1);
                String nombreUsuario = resultSet.getString(2);
                String apeUsuario = resultSet.getString(3);
                String mailUsuario = resultSet.getString(4);
                String pwdUsuario = resultSet.getString(5);
                Date fnacUsuario = resultSet.getDate(6);
                String paisUsuario = resultSet.getString(7);
                UsuariosDTO c = new UsuariosDTO(idUsuario, nombreUsuario, apeUsuario, mailUsuario, pwdUsuario, fnacUsuario, paisUsuario);
                usrs.add(c);
            }
        } catch(Exception e) {
            System.err.println(e);
        } finally {
            AdministradorDeConexiones.cerrarConexion(con);
        }
        return usrs;
    }
    
}
