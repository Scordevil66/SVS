/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio;

/**
 *
 * @author Gustavo
 */
public interface EditarEmpresas {

    public int editarEmpresas(int idEmpresa, int idUsuario, String nombre, String direccion, String nit, String telefono, String correo, String urlLogo, String urlBanner, int comite) throws Exception;

}
