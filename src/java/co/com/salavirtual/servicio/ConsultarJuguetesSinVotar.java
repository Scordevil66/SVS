/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio;

import co.com.salavirtual.modelo.dto.Inventario_TO;
import java.util.List;

/**
 *
 * @author kira
 */
public interface ConsultarJuguetesSinVotar {
    
     public List<Inventario_TO> consultarJuguetesSinVotar(int idEmpresa) throws Exception;
}
