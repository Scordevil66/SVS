/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.servicio;

/**
 *
 * @author Gustavo Cardenas
 */
public interface RegistrarCiudad {
    
    public int registrarCiudad(String nombre, String descripcion, int idDepartamento) throws Exception;
    
}
