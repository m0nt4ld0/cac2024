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

@WebServlet("/EditarUsuarioController")
public class EditarUsuarioController extends HttpServlet{
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configuración de CORS
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "PUT, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        UsuariosService us = new UsuariosService();
        
        String jsonRecibido = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(jsonRecibido);
        
        ObjectMapper om = new ObjectMapper();

        try {
            UsuariosDTO uDto = om.readValue(jsonRecibido, UsuariosDTO.class);
            System.out.println(uDto.toString());
            us.editarUsuarioPorId(uDto);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch(Exception ex) {
            System.err.println("Error al obtener el ID de usuario." + ex.toString());
        }
    }
    
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "PUT, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
