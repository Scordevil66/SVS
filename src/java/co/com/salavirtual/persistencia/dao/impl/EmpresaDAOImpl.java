/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.persistencia.dao.impl;

import co.com.salavirtual.conexion.ConexionSQL;
import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Usuario_TO;
import co.com.salavirtual.persistencia.dao.EmpresaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class EmpresaDAOImpl implements EmpresaDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * METODOS PARA CONSULTAR Empresas
     *
     * @return @throws Exception
     */
    @Override
    public List<Empresa_TO> consultarEmpresas() throws Exception {
        List<Empresa_TO> empresas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idEmpresa, nombre, direccion, nit, telefono, correo, urlLogo, urlBanner, idUsuario, comite FROM empresa order by nombre asc; ";
                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    empresas.add(new Empresa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new Usuario_TO(rs.getInt(9)), rs.getInt(10)));

                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return empresas;
    }

    /**
     *
     * METODOS PARA CONSULTAR Empresas
     *
     * @param idUsuario
     * @return @throws Exception
     */
    @Override
    public List<Empresa_TO> consultarEmpresasPorAdministrador(int idUsuario) throws Exception {
        List<Empresa_TO> empresas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idEmpresa, nombre, direccion, nit, telefono, correo, urlLogo, urlBanner, idUsuario, comite FROM empresa where idUsuario = " + idUsuario + "; ";
                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    empresas.add(new Empresa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new Usuario_TO(rs.getInt(9)), rs.getInt(10)));

                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return empresas;
    }

    /**
     *
     * METODOS PARA CREAR Empresas
     *
     * @param idUsuario
     * @param nombre
     * @param direccion
     * @param nit
     * @param telefono
     * @param correo
     * @param urlLogo
     * @param urlBanner
     * @return @throws Exception
     */
    @Override
    public int crearEmpresas(String nombre, String direccion, String nit, String telefono, String correo, String urlLogo, String urlBanner, int idUsuario, int comite) throws Exception {

        int resultado = 0;
        try {
            try {
                String sql = "INSERT INTO empresa "
                        + "(nombre, "
                        + "direccion, "
                        + "nit, "
                        + "telefono, "
                        + "correo, "
                        + "urlLogo, "
                        + "urlBanner,"
                        + "idUsuario,"
                        + "comite) "
                        + "VALUES ("
                        + "'" + nombre + "', "
                        + "'" + direccion + "', "
                        + "'" + nit + "', "
                        + "'" + telefono + "', "
                        + "'" + correo + "', "
                        + "'" + urlLogo + "', "
                        + "'" + urlBanner + "', "
                        + "'" + idUsuario + "', "
                        + "'" + comite + "');";
                st.execute(sql);
                resultado = 1;
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return resultado;
    }

    /**
     *
     * METODOS PARA Editar Empresas
     *
     * @param idEmpresa
     * @param idUsuario
     * @param nombre
     * @param direccion
     * @param nit
     * @param telefono
     * @param correo
     * @param urlLogo
     * @param urlBanner
     * @return @throws Exception
     */
    @Override
    public int editarEmpresas(int idEmpresa, String nombre, String direccion, String nit, String telefono, String correo, String urlLogo, String urlBanner, int idUsuario, int comite) throws Exception {

        int resultado = 0;
        try {
            String sql = "UPDATE `salavirtual`.`empresa` "
                    + "SET "
                    + "`nombre` =  '" + nombre + "', "
                    + "`direccion` =  '" + direccion + "', "
                    + "`nit` =  '" + nit + "', "
                    + "`telefono` =  '" + telefono + "', "
                    + "`correo` =  '" + correo + "', "
                    + "`urlLogo` = '" + urlLogo + "', "
                    + "`urlBanner` =  '" + urlBanner + "', "
                    + "idUsuario = '" + idUsuario + "',"
                    + "comite = '" + comite + "' "
                    + "WHERE `idEmpresa` =  " + idEmpresa + ";";
            st.execute(sql);
            resultado = 1;
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return resultado;
    }

    /**
     *
     * METODOS PARA Eliminar Empresas
     *
     * @param idEmpresa
     * @return @throws Exception
     */
    @Override
    public int eliminarEmpresas(int idEmpresa) throws Exception {

        int resultado = 0;
        try {
            try {
                String sql = "SET SQL_SAFE_UPDATES = 0;";
                
                String sql1 = "Delete from salavirtual.votacion where idInventario in (select idInventario from salavirtual.inventario where idEmpresa = "+idEmpresa+");";
                
                /* elimina todo el inventario de la empresa*/
                String sql2 ="DELETE FROM salavirtual.inventario where idEmpresa = "+idEmpresa+";";
                
                /* elimina todos los pedidos de la empresa*/
                String sql3 ="DELETE FROM salavirtual.pedido where idUsuario in (select idusuario from salavirtual.usuario where idEmpresa =  "+idEmpresa+");";
                
                String sql4 ="DELETE FROM salavirtual.usuario where idEmpresa = "+idEmpresa+";";
                
                String sql5 ="Delete from salavirtual.comite where idEmpresa = "+idEmpresa+";";

                String sql6 ="DELETE FROM `salavirtual`.`empresa` WHERE idEmpresa = "+idEmpresa+";";

                st.execute(sql);
                st.execute(sql1);
                st.execute(sql2);
                st.execute(sql3);
                st.execute(sql4);
                st.execute(sql5);
                st.execute(sql6);
                resultado = 1;
            } catch (SQLException e) {
                resultado = 0;
                throw e;
            }
        } catch (Exception e) {
            resultado = 0;
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return resultado;
    }

    @Override
    public Empresa_TO consultarEmpresa(int idEmpresa, String nombre) throws Exception {
        Empresa_TO empresas = new Empresa_TO();
        String sql = "";
        try {
            try {
                if (idEmpresa > 0 && nombre == null) {
                    sql = "SELECT idEmpresa, nombre, direccion, nit, telefono, correo, urlLogo, urlBanner, idUsuario, comite FROM empresa "
                            + "WHERE idEmpresa = " + idEmpresa + ";";

                } else if (idEmpresa == 0 && !(nombre.trim().equals(""))) {
                    sql = "SELECT idEmpresa, nombre, direccion, nit, telefono, correo, urlLogo, urlBanner, idUsuario, comite FROM empresa "
                            + "WHERE nombre Like '" + nombre.trim() + "%';";

                } else if (idEmpresa > 0 && !(nombre.trim().equals(""))) {
                    sql = "SELECT idEmpresa, nombre, direccion, nit, telefono, correo, urlLogo, urlBanner, idUsuario, comite FROM empresa "
                            + "WHERE idEmpresa = " + idEmpresa + " and nombre Like '" + nombre.trim() + "%';";
                }
                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    empresas = new Empresa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new Usuario_TO(rs.getInt(9)), rs.getInt(10));

                }
            } catch (SQLException e) {
                empresas = new Empresa_TO();
                throw e;
            }
        } catch (Exception e) {
            empresas = new Empresa_TO();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return empresas;
    }

    @Override
    public List<Empresa_TO> consultarEmpresasConComite() throws Exception {
        List<Empresa_TO> empresas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idEmpresa, nombre, direccion, nit, telefono, correo, urlLogo, urlBanner, idUsuario, comite FROM empresa WHERE comite = 1; ";
                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    empresas.add(new Empresa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new Usuario_TO(rs.getInt(9)), rs.getInt(10)));

                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return empresas;
    }

}
