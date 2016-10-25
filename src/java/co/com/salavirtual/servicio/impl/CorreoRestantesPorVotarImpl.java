/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Usuario_TO;
import co.com.salavirtual.persistencia.dao.impl.CorreoDAOImpl;
import co.com.salavirtual.servicio.CorreoRestantesPorVotar;
import co.com.salavirtual.servicio.CorreoVotacion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/correoRestantesPorVotar")
public class CorreoRestantesPorVotarImpl implements CorreoRestantesPorVotar  {
    
    Usuario_TO user =  new Usuario_TO();
    Empresa_TO emp = new Empresa_TO();
    
    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int correoRestantesPorVotar(@QueryParam("nombreUsuario")String nombreUsuario , @QueryParam("usuario")String usuario ,@QueryParam("contrasena") String contrasena, @QueryParam("email")String email) throws Exception {

        CorreoDAOImpl correoDAO = new CorreoDAOImpl();
        
        user.setNombre(nombreUsuario);
        user.setEmail(email);
        user.setContrasena(contrasena);
        user.setUsuario(usuario);
       

        return correoDAO.correoRestantesPorVotar(user);

    }

    
}
