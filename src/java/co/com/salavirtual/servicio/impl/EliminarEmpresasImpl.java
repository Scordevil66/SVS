/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.persistencia.dao.impl.EmpresaDAOImpl;
import co.com.salavirtual.servicio.EliminarEmpresas;
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
@Path("/eliminarEmpresas")
public class EliminarEmpresasImpl implements EliminarEmpresas {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int eliminarEmpresas(@QueryParam("idEmpresas") int idEmpresas) throws Exception {

        EmpresaDAOImpl empresaDAO = new EmpresaDAOImpl();
        int resultado = 0;
        resultado = empresaDAO.eliminarEmpresas(idEmpresas);
        return resultado;
    }

}
