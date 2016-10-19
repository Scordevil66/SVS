/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.persistencia.dao.impl.ComiteDAOImpl;
import co.com.salavirtual.persistencia.dao.impl.EmpresaDAOImpl;
import co.com.salavirtual.servicio.EditarComite;
import co.com.salavirtual.servicio.EditarStatusUsuarioComite;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gustavo Cardenas
 */
@Stateless
@Path("/editarStatusUsuarioComite")
public class EditarStatusUsuarioComiteImpl implements EditarStatusUsuarioComite {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int editarStatusUsuarioComite(@QueryParam("idUsuario") int idUsuario, @QueryParam("status") int status) throws Exception {

        ComiteDAOImpl comiteDAO = new ComiteDAOImpl();
        int resultado = 0;
        resultado = comiteDAO.editarStatusUsuarioComite(idUsuario, status);
        return resultado;
    }

}
