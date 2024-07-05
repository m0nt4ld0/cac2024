package controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.UsuariosDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

@WebServlet("/ListarUsuariosController")
public class ListarUsuariosController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // To DO: Agregar validaciones
        UsuariosService us = new UsuariosService();
        ArrayList<UsuariosDTO> usrs = us.obtenerUsuarios();
        ObjectMapper om = new ObjectMapper();
        String usrsJSON = om.writeValueAsString(usrs);

        // Configurar cabeceras CORS
        resp.setHeader("Access-Control-Allow-Origin","*"); // Permitir acceso desde cualquier origen
        resp.setHeader("Access-Control-Allow-Methods","*"); // Métodos permitidos
        resp.setHeader("Access-Control-Allow-Headers","*"); // Cabeceras permitidas

        resp.getWriter().println(usrsJSON);
    }

}
