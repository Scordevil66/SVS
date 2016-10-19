/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.persistencia.dao.impl;

import co.com.salavirtual.conexion.ConexionSQL;
import co.com.salavirtual.modelo.dto.Comite_TO;
import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Estado_TO;
import co.com.salavirtual.persistencia.dao.ComiteDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ComiteDAOImpl implements ComiteDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * METODOS PARA CONSULTAR Comite
     *
     * @return @throws Exception
     */
    @Override
    public List<Comite_TO> consultarComite() throws Exception {

        List<Comite_TO> comite = new ArrayList<>();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
//            String date = new Date().toString();
            System.out.println(date); //15/10/2013

            String sql = "SELECT idComite, idEstado, nombre, descripcion, fechaApertura, fechaCierre, idEmpresa FROM comite where idEstado = 1 and fechaApertura <= '" + date + "' and fechaCierre >= '" + date + "'";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(rs.getDate(5).toString());

                String[] fechaApertura = null, fechaCierre = null;

                fechaApertura = rs.getDate(5).toString().split("T");

                String fechaAperturaS = fechaApertura[0];

                fechaCierre = rs.getDate(6).toString().split("T");

                String fechaCierreS = fechaCierre[0];

                comite.add(new Comite_TO(rs.getInt(1), new Estado_TO(rs.getInt(2)), rs.getString(3), rs.getString(4), fechaAperturaS, fechaCierreS, new Empresa_TO(rs.getInt(7))));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return comite;
    }

    /**
     *
     * METODOS PARA Crear Comite
     *
     * @param idEstado
     * @param nombre
     * @param descripcion
     * @param fechaApertura
     * @param fechaCierre
     * @return @throws Exception
     */
    @Override
    public int crearComite(int idEstado, String nombre, String descripcion, String fechaApertura, String fechaCierre, int idEmpresa) throws Exception {

        int resultado = 0;

        try {

            String sql = "INSERT INTO `salavirtual`.`comite`  "
                    + "                    (`idEstado`,  "
                    + "                    `nombre`,  "
                    + "                    `descripcion`,  "
                    + "                    `fechaApertura`,  "
                    + "                    `fechaCierre`, "
                    + "idEmpresa)  "
                    + "                    VALUES ("
                    + "                     " + idEstado + " ,  "
                    + "				 '" + nombre + " ' ,  "
                    + "                  '" + descripcion + " '  ,  "
                    + "                     '" + fechaApertura + " ' ,  "
                    + "                     '" + fechaCierre + " ',"
                    + " '" + idEmpresa + "');";

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
     * METODOS PARA Editar Comite
     *
     * @param idComite
     * @param idEstado
     * @param nombre
     * @param descripcion
     * @param fechaApertura
     * @param fechaCierre
     * @return @throws Exception
     */
    @Override
    public int editarComite(int idComite, int idEstado, String nombre, String descripcion, String fechaApertura, String fechaCierre, int idEmpresa) throws Exception {

        int resultado = 0;

        try {

            String sql = "UPDATE `salavirtual`.`comite` "
                    + "SET "
                    + "`idEstado` = " + idEstado + ", "
                    + "`nombre` = '" + nombre + "', "
                    + "`descripcion` = '" + descripcion + "', "
                    + "`fechaApertura` = '" + fechaApertura + "', "
                    + "`fechaCierre` =' " + fechaCierre + "', "
                    + "idEmpresa ='" + idEmpresa + "' "
                    + "WHERE `idComite` = " + idComite + ";";

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
     * METODOS PARA Editar Comite
     *
     * @param idUsuario
     * @param status
     *
     * @return @throws Exception
     */
    @Override
    public int editarStatusUsuarioComite(int idUsuario, int status) throws Exception {

        int resultado = 0;

        try {

            String sql = "UPDATE `salavirtual`.`comite_usuario` "
                    + " SET "
                    + " Status = " + status
                    + " WHERE `idUsuario` = " + idUsuario + ";";

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
     * METODOS PARA Eliminar Comite
     *
     * @param idComite
     * @return @throws Exception
     */
    @Override
    public int eliminarComite(int idComite) throws Exception {

        int resultado = 0;

        try {

            String sql = "DELETE FROM `salavirtual`.`comite`\n"
                    + "WHERE idComite = " + idComite + ";";

            st.execute(sql);

            resultado = 1;

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return resultado;
    }

    @Override
    public Comite_TO consultarComite(Comite_TO comite) throws Exception {
        Comite_TO nuevocomite = new Comite_TO();
        try {
            String sql = "SELECT idComite, idEstado, nombre, descripcion, fechaApertura, fechaCierre, idEmpresa FROM comite "
                    + "WHERE idComite = '" + comite.getIdComite() + "' or nombre = '" + comite.getNombre() + "'";

            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                nuevocomite = new Comite_TO(rs.getInt(1), new Estado_TO(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), new Empresa_TO(rs.getInt(7)));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevocomite;
    }

    /**
     *
     * METODOS PARA CONSULTAR Comite
     *
     * @return @throws Exception
     */
    @Override
    public int consultarComitePorUsuario(int idUsuario) throws Exception {

        int valor = 0;

        try {

            String sql = "SELECT `u`.`idUsuario`, "
                    + "    `u`.`idEmpresa`, "
                    + "    `u`.`idTipoUsuario`, "
                    + "    `u`.`idCiudad`, "
                    + "    `u`.`idDepartamento`, "
                    + "    `u`.`nombre`, "
                    + "    `u`.`codigoEmpleado`, "
                    + "    `u`.`cc`, "
                    + "    `u`.`telefono`, "
                    + "    `u`.`email`, "
                    + "    `u`.`usuario`, "
                    + "    `u`.`contrasena`, "
                    + "    `u`.`oficina`, "
                    + "    `u`.`areaTrabajo`,  "
                    + "    `cu`.`idComite` "
                    + " FROM `salavirtual`.`usuario` as  `u`, `salavirtual`.`comite_usuario` as cu "
                    + " WHERE u.idUsuario = cu.idUsuario and u.idUsuario = " + idUsuario + " and cu.Status = 1;";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                valor = rs.getInt(15);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return valor;
    }

    /**
     *
     * METODOS PARA CONSULTAR Comite
     *
     * @param idUsuario
     * @return @throws Exception
     */
    @Override
    public List<Comite_TO> consultarComitesPorUsuario(int idUsuario) throws Exception {

        List<Comite_TO> comites = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());

            String sql = "SELECT co.idComite, co.idEstado, co.nombre, co.descripcion, co.fechaApertura, co.fechaCierre, co.idEmpresa FROM comite as co, empresa as emp "
                    + "WHERE emp.idEmpresa = co.idEmpresa and co.idEstado = 1 and emp.idUsuario = " + idUsuario + " and fechaApertura <= '" + date + "' and fechaCierre >= '" + date + "'";

            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] fechaApertura = null, fechaCierre = null;

                fechaApertura = rs.getDate(5).toString().split("T");

                String fechaAperturaS = fechaApertura[0];

                fechaCierre = rs.getDate(6).toString().split("T");

                String fechaCierreS = fechaCierre[0];

                comites.add(new Comite_TO(rs.getInt(1), new Estado_TO(rs.getInt(2)), rs.getString(3), rs.getString(4), fechaAperturaS, fechaCierreS, new Empresa_TO(rs.getInt(7))));

            }

        } catch (Exception e) {
            comites = new ArrayList<>();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return comites;
    }

}
