package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

@WebServlet("/EliminarUsuarioController")
public class EliminarUsuarioController extends HttpServlet{

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configuración de las cabeceras de CORS
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        UsuariosService us = new UsuariosService();
        String aux = req.getParameter("idUsuario");
        Long idUsr = null;
        try {
            idUsr = Long.parseLong(aux);
            us.eliminarUsuarioPorId(idUsr);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch(Exception ex) {
            if(idUsr != null)
                System.err.println("Error al eliminar usuario de ID " + idUsr);
            else
                System.err.println("Error al obtener el ID de usuario.");
        }
    }
    
    // Método para manejar las solicitudes OPTIONS, necesarias para CORS preflight
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
}
