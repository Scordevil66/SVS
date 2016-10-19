/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Pedido_TO;
import co.com.salavirtual.persistencia.dao.impl.PedidoDAOImpl;
import co.com.salavirtual.servicio.ConsultarPedidosPorEmpresa;
import co.com.salavirtual.servicio.ConsultarPedidosPorId;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarPedidosPorEmpresa")
public class ConsultarPedidosPorEmpresaImpl implements ConsultarPedidosPorEmpresa {

    @GET
    @Produces({"application/json"})
    @Override
    public List<Pedido_TO> consultarPedidosPorEmpresa(@QueryParam("idEmpresa") int idEmpresa) throws Exception {
        List<Pedido_TO> pedidos = new ArrayList<>();
        PedidoDAOImpl pedidoDao = new PedidoDAOImpl();
        return pedidoDao.consultarPedidosPorEmpresa(idEmpresa);
    }

}
