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
public interface ConsultarJuguetesMasVotadosGenero {
    
     public List<Inventario_TO> consultarJuguetesMasVotadosGenero(int idEmpresa, String genero) throws Exception;
}
