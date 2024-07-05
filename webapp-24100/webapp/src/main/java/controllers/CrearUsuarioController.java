package controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.UsuariosDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

@WebServlet("/CrearUsuarioController")
public class CrearUsuarioController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configurar cabeceras CORS
        resp.setHeader("Access-Control-Allow-Origin","*"); // Permitir acceso desde cualquier origen
        resp.setHeader("Access-Control-Allow-Methods","POST, OPTIONS"); // Métodos permitidos
        resp.setHeader("Access-Control-Allow-Headers","Content-Type"); // Cabeceras permitidas

        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        String jsonRecibido = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(jsonRecibido);

        // Si se pudo crear, el backend devuelve el código HTTP 201
        // Ver códigos de estado HTTP en Mozilla para mas detalles
        
        UsuariosService us = new UsuariosService();
        ObjectMapper om = new ObjectMapper();
        try {
            UsuariosDTO udto = om.readValue(jsonRecibido, UsuariosDTO.class);
            if(udto.getMailUsuario() == null || udto.getMailUsuario().isBlank())
                return;
            us.nuevoUsuario(udto);
            resp.setStatus(HttpServletResponse.SC_CREATED); /////creado
        } catch (Exception ex) {
            System.err.println("Error al dar de alta el usuario." + ex.toString());
        }
    }
    
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configurar cabeceras CORS para las solicitudes preflight
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methods","POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers","Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
