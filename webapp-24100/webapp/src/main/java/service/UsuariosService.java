package service;

import java.util.ArrayList;

import dao.UsuariosDAO;
import dao.UsuariosDAOMySQLImpl;
import dto.UsuariosDTO;
import web.Usuarios;

public class UsuariosService {
    // Estas clases de servicios tienen la lógica de negocio
    
    private UsuariosDAO uDao;

    public UsuariosService() {
        this.uDao = new UsuariosDAOMySQLImpl();
    }

    public Usuarios obtenerUsuariosPorId(Long id){
        return this.uDao.getUsuarioById(id);
    }

    public ArrayList<UsuariosDTO> obtenerUsuarios() {
        return this.uDao.findAll();
    }

    public void eliminarUsuarioPorId(Long id){
        this.uDao.deleteUsuarioById(id);
    }

    public void nuevoUsuario(UsuariosDTO u) {
        this.uDao.crearUsuario(u);
    }

    public void editarUsuarioPorId(UsuariosDTO u) {
        this.uDao.editarUsuario(u);
    }
}
