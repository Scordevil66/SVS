/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio;


import co.com.salavirtual.modelo.dto.Usuario_TO;
import java.util.List;

/**
 *
 * @author kira
 */
public interface ValidarQuienVoto {

    public int validarPersonasComite(int idEmpresa) throws Exception;

}
