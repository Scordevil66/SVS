/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio;

/**
 *
 * @author SISTEMAS
 */
public interface CorreoCreacionAdministrador {
    
     public int correoCreacionAdministrador( String nombreUsuario , String nombreEmpresa , String usuario , String contrasena, String email)throws Exception;
    
    
}
