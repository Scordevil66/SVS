/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Ciudad_TO;
import co.com.salavirtual.modelo.dto.Departamento_TO;
import co.com.salavirtual.modelo.dto.Pedido_TO;
import co.com.salavirtual.modelo.dto.Usuario_TO;
import co.com.salavirtual.persistencia.dao.impl.CiudadDAOImpl;
import co.com.salavirtual.persistencia.dao.impl.PedidoDAOImpl;
import co.com.salavirtual.servicio.RegistrarCiudad;
import co.com.salavirtual.servicio.RegistrarPedido;
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
@Path("/registrarCiudad")
public class RegistrarCiudadImpl implements RegistrarCiudad {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int registrarCiudad(@QueryParam("nombre") String nombre,
            @QueryParam("descripcion") String descripcion, @QueryParam("idDepartamento") int idDepartamento) throws Exception {

        Ciudad_TO cid = new Ciudad_TO();
        Departamento_TO dep = new Departamento_TO();
        dep.setIdDepartamento(idDepartamento);
        cid.setNombre(nombre);
        cid.setDescripcion(descripcion);
        cid.setIdDepartamento(dep);
        CiudadDAOImpl ciudadDao = new CiudadDAOImpl();
        return ciudadDao.registrarCiudad(cid);
    }

}
