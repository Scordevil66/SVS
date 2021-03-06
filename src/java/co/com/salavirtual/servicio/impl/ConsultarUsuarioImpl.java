/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Usuario_TO;
import co.com.salavirtual.persistencia.dao.UsuarioDAO;
import co.com.salavirtual.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.salavirtual.servicio.ConsultarUsuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarUsuarios")
public class ConsultarUsuarioImpl implements ConsultarUsuarios{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Usuario_TO> consultarUsuarios() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        return  usuarioDAO.consultarUsuarios();
    }
    
}
