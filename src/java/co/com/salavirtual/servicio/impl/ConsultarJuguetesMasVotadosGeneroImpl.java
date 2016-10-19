package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Inventario_TO;
import co.com.salavirtual.persistencia.dao.impl.JugueteDAOImpl;
import co.com.salavirtual.persistencia.dao.impl.VotacionDAOImpl;
import co.com.salavirtual.servicio.ConsultarJuguetesMasVotados;
import co.com.salavirtual.servicio.ConsultarJuguetesMasVotadosGenero;
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
@Path("/consultarJuguetesMasVotadosGenero")
public class ConsultarJuguetesMasVotadosGeneroImpl implements ConsultarJuguetesMasVotadosGenero {

    @GET
    @Produces({"application/json"})  
    @Override
    public List<Inventario_TO> consultarJuguetesMasVotadosGenero(@QueryParam("idEmpresa") int idEmpresa, @QueryParam("genero") String genero) throws Exception {
        VotacionDAOImpl votacionDAO = new VotacionDAOImpl();
        List<Inventario_TO> inventarios = new ArrayList<>();
        inventarios = votacionDAO.consultarJuguetesMasVotadosGenero(idEmpresa, genero.trim());
        return inventarios;
    }
}
