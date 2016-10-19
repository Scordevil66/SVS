/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Inventario_TO;
import co.com.salavirtual.persistencia.dao.JugueteDAO;
import co.com.salavirtual.persistencia.dao.impl.JugueteDAOImpl;
import co.com.salavirtual.servicio.EditarJuguete;
import co.com.salavirtual.servicio.EditarStatusJuguete;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author CristianCamilo
 */
@Stateless
@Path("/editarStatusJuguete")
public class EditarStatusJugueteImpl implements EditarStatusJuguete {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int editarStatusJuguete(@QueryParam("idinventario") int idInventario) throws Exception {

        JugueteDAO jugueteDao = new JugueteDAOImpl();
        return  jugueteDao.EditarStatusJuguete(idInventario);
    }

}
