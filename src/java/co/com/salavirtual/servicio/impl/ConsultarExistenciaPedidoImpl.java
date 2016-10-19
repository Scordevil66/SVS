/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Pedido_TO;
import co.com.salavirtual.persistencia.dao.impl.PedidoDAOImpl;
import co.com.salavirtual.servicio.ConsultarExistenciaPedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author cesar
 */
@Stateless
@Path("/consultarExistenciaPedido")
public class ConsultarExistenciaPedidoImpl implements ConsultarExistenciaPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public List<Pedido_TO> consultarExistenciaPedido(@QueryParam("idUsuario") int idUsuario,
           @QueryParam("nombreHijo") String nombreHijo,@QueryParam("edadHijo")  int edadHijo) throws Exception {

        PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
        List<Pedido_TO> pedidos = new ArrayList<>();
        pedidos = pedidoDAO.consultarExistenciaPedido(idUsuario, nombreHijo, edadHijo);
        return pedidos;
    }

}
