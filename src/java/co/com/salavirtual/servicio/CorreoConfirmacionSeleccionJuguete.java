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
public interface CorreoConfirmacionSeleccionJuguete {
     public int correoConfirmacionSeleccionJuguete( String nombreUsuario  ,String nombreHijo , String codigoInventario , String ticket , String nombreJuguete, String usuario, String email)throws Exception;
    
    
}
