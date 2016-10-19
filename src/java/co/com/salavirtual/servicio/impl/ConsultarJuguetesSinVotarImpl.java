package co.com.salavirtual.servicio.impl;

import co.com.salavirtual.modelo.dto.Inventario_TO;
import co.com.salavirtual.persistencia.dao.impl.JugueteDAOImpl;
import co.com.salavirtual.persistencia.dao.impl.VotacionDAOImpl;
import co.com.salavirtual.servicio.ConsultarJuguetesMasVotados;
import co.com.salavirtual.servicio.ConsultarJuguetesSinVotar;
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
@Path("/consultarJuguetesSinVotar")
public class ConsultarJuguetesSinVotarImpl implements ConsultarJuguetesSinVotar {

    @GET
    @Produces({"application/json"})  
    @Override
    public List<Inventario_TO> consultarJuguetesSinVotar(@QueryParam("idEmpresa") int idEmpresa) throws Exception {
        VotacionDAOImpl votacionDAO = new VotacionDAOImpl();
        List<Inventario_TO> inventarios = new ArrayList<>();
        inventarios = votacionDAO.consultarJuguetesSinVotar(idEmpresa);
        return inventarios;
    }
}
