package dao;

import java.util.ArrayList;

import dto.UsuariosDTO;
import web.Usuarios;

// La interfaz nos dice el qué

public interface UsuariosDAO {
    public Usuarios getUsuarioById(Long id);
    public void crearUsuario(UsuariosDTO u);
    public void deleteUsuarioById(Long id);
    public ArrayList<UsuariosDTO> findAll();
    public void editarUsuario(UsuariosDTO u);
}
