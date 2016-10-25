package co.com.salavirtual.persistencia.dao.impl;

import co.com.salavirtual.conexion.ConexionSQL;
import co.com.salavirtual.modelo.dto.Comite_TO;
import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Inventario_TO;
import co.com.salavirtual.modelo.dto.Usuario_TO;
import co.com.salavirtual.modelo.dto.Votacion_TO;
import co.com.salavirtual.persistencia.dao.VotacionDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Ciudad
 *
 * @author SISTEMAS
 */
public class VotacionDAOImpl implements VotacionDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * METODOS PARA CONSULTAR CIUDADES
     *
     * @return @throws Exception
     */
    @Override
    public List<Votacion_TO> consultarVotacion() throws Exception {
        List<Votacion_TO> votaciones = new ArrayList<>();

        try {

            String sql = "SELECT idVotacion, calificacion, fechaCalificacion, idComite, idInventario, idUsuario; ";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                votaciones.add(new Votacion_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Comite_TO(rs.getInt(4)), new Inventario_TO(rs.getInt(5)), new Usuario_TO(rs.getInt(6))));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return votaciones;
    }

    /**
     *
     * METODOS PARA CREAR Votaciones
     *
     * @param idUsuario
     * @param idInventario
     * @param idComite
     * @param fechaCalificacion
     * @param calificacion
     * @return @throws Exception
     */
    @Override
    public int crearVotacion(int idUsuario, int idInventario, int idComite, String fechaCalificacion, String calificacion) throws Exception {

        int resultado = 0;

        try {

            String sql = "INSERT INTO `salavirtual`.`votacion` "
                    + "(`idUsuario`, "
                    + "`idInventario`, "
                    + "`idComite`, "
                    + "`fechaCalificacion`, "
                    + "`calificacion`)"
                    + "VALUES ("
                    + idUsuario + ", "
                    + idInventario + ", "
                    + idComite + ",' "
                    + fechaCalificacion + "',' "
                    + calificacion + "');";

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
     * METODOS PARA CONSULTAR CIUDADES
     *
     * @param idUsuario
     * @return @throws Exception
     */
    @Override
    public int validarVotacionPorUsuario(int idUsuario) throws Exception {
        int valor = 0;

        try {

            String sql = "SELECT `v`.`idVotacion`,\n"
                    + "    `v`.`calificacion`,\n"
                    + "    `v`.`fechaCalificacion`,\n"
                    + "    `v`.`idComite`,\n"
                    + "    `v`.`idInventario`,\n"
                    + "    `v`.`idUsuario`\n"
                    + "FROM `salavirtual`.`votacion` as v, `salavirtual`.`usuario` as u \n"
                    + "WHERE  v.idUsuario = u.idUsuario and u.idUsuario = " + idUsuario + "; ";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                valor++;

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
     * METODOS PARA CONSULTAR CIUDADES
     *
     * @param idUsuario
     * @param idInventario
     * @return @throws Exception
     */
    @Override
    public int validarVotacionPorUsuarioInventario(int idUsuario, int idInventario) throws Exception {
        int valor = 0;

        try {

            String sql = " SELECT `v`.`idVotacion`,\n"
                    + "    `v`.`calificacion`,\n"
                    + "    `v`.`fechaCalificacion`,\n"
                    + "    `v`.`idComite`,\n"
                    + "    `v`.`idInventario`,\n"
                    + "    `v`.`idUsuario`\n"
                    + " FROM `salavirtual`.`votacion` as v, `salavirtual`.`usuario` as u "
                    + " WHERE  v.idUsuario = u.idUsuario and u.idUsuario = " + idUsuario + " and v.idInventario = " + idInventario + "; ";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                valor++;

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
     * METODOS PARA CONSULTAR Quien ha Votado
     *
     * @param idEmpresa
     * @return @throws Exception
     */
    @Override
    public int validarPersonasComite(int idEmpresa) throws Exception {

        int user = 0;

        try {

            String sql = " SELECT COUNT(u.idUsuario) as usuario FROM comite_usuario as cu, empresa as e, usuario as u "
                    + " where u.idempresa = e.idempresa and u.idempresa= " + idEmpresa + " "
                    + " and cu.idusuario = u.idusuario  ; ";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                user = rs.getInt(1);

            }

        } catch (Exception e) {
            user = 0;
            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }
        return user;
    }

    /**
     *
     * METODOS PARA CONSULTAR Quien ha Votado
     *
     * @param idEmpresa
     * @return @throws Exception
     */
    @Override
    public List<Usuario_TO> validarQuienNoVoto(int idEmpresa) throws Exception {

        List<Usuario_TO> usuarios = new ArrayList<>();

        try {

            String sql = " SELECT us.idusuario, us.nombre, us.email, c.nombre, c.fechaApertura, c.fechaCierre "
                    + " FROM salavirtual.usuario AS us, salavirtual.comite AS c, salavirtual.comite_usuario as cu "
                    + " WHERE us.idusuario = cu.idusuario and c.idComite = cu.idComite and us.idempresa = " + idEmpresa + " and c.idempresa = us.idempresa and  us.idusuario NOT "
                    + " IN (SELECT v.idusuario "
                    + " FROM salavirtual.votacion AS v);";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                usuarios.add(new Usuario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Comite_TO(rs.getString(4), rs.getString(5), rs.getString(6))));

            }

        } catch (Exception e) {
            usuarios = new ArrayList<>();
            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }
        return usuarios;
    }

    /**
     *
     * METODOS PARA CONSULTAR El ARTICULO MAS VOTADO
     *
     * @param idInventario
     * @return @throws Exception
     */
    @Override
    public int consultarIdJugueteMasVotado() throws Exception {
        int valor = 0;

        try {

            String sql = "SELECT idInventario FROM (SELECT idInventario, COUNT( idInventario ) contador "
                    + "FROM salavirtual.votacion GROUP BY idInventario) AS T1 "
                    + "WHERE contador IN "
                    + "(SELECT MAX( contador ) "
                    + "FROM "
                    + "(SELECT idInventario, COUNT( idInventario ) contador FROM salavirtual.votacion GROUP BY idInventario) AS T2)";

            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                valor = rs.getInt(1);

            }

        } catch (Exception e) {
            valor = 0;
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return valor;
    }

    @Override
    public List<Inventario_TO> consultarJuguetesMasVotados(int idEmpresa) throws Exception {
        List<Inventario_TO> inventarios = new ArrayList<>();
        try {

            String sql = "SELECT SUM(vo.calificacion) AS Calificacion, vo.idInventario, inv.codigo, inv.nombre, inv.descripcion, inv.edadDesde, inv.edadHasta, "
                    + "  inv.genero, inv.cantidad, inv.url1, inv.url2, inv.url3, inv.url4, inv.url5, inv.url6, inv.url7, inv.url8, inv.url9, inv.url10, "
                    + "  inv.url11, inv.url12, inv.observacion, inv.idEmpresa "
                    + "  FROM votacion as vo, inventario as inv "
                    + "  where vo.idInventario=inv.idInventario and inv.status = 1 AND inv.idEmpresa = '" + idEmpresa + "'"
                    + "GROUP BY idInventario ORDER by calificacion desc";

            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                inventarios.add(new Inventario_TO(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getInt(1), new Empresa_TO(rs.getInt(23))));
            }

        } catch (Exception e) {
            inventarios = new ArrayList<>();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return inventarios;
    }

    @Override
    public List<Inventario_TO> consultarJuguetesSinVotar(int idEmpresa) throws Exception {
        List<Inventario_TO> inventarios = new ArrayList<>();
        try {

            String sql = "SELECT inv.idInventario, inv.codigo, inv.nombre, inv.descripcion, inv.edadDesde, inv.edadHasta, "
                    + "  inv.genero, inv.cantidad, inv.url1, inv.url2, inv.url3, inv.url4, inv.url5, inv.url6, inv.url7, inv.url8, inv.url9, inv.url10, "
                    + "  inv.url11, inv.url12, inv.observacion, inv.idEmpresa "
                    + "  FROM inventario as inv "
                    + "  where inv.status = 1 AND inv.idEmpresa = '" + idEmpresa + "' and inv.idInventario NOT IN (Select idInventario from votacion)"
                    + "GROUP BY idInventario ORDER by idInventario desc";

            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                inventarios.add(new Inventario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), getString(18), rs.getString(19), rs.getString(20), rs.getString(21), 0, new Empresa_TO(rs.getInt(22))));
            }

        } catch (Exception e) {
            inventarios = new ArrayList<>();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return inventarios;
    }

    @Override
    public List<Inventario_TO> consultarJuguetesMasVotadosGenero(int idEmpresa, String genero) throws Exception {
        List<Inventario_TO> inventarios = new ArrayList<>();
        try {

            String sql = "SELECT SUM(vo.calificacion) AS Calificacion, vo.idInventario, inv.codigo, inv.nombre, inv.descripcion, inv.edadDesde, inv.edadHasta, "
                    + "  inv.genero, inv.cantidad, inv.url1, inv.url2, inv.url3, inv.url4, inv.url5, inv.url6, inv.url7, inv.url8, inv.url9, inv.url10, "
                    + "  inv.url11, inv.url12, inv.observacion, inv.idEmpresa "
                    + "  FROM votacion as vo, inventario as inv "
                    + "  where vo.idInventario=inv.idInventario and inv.status = 1 and inv.genero = '" + genero.trim() + "' AND inv.idEmpresa = '" + idEmpresa + "'"
                    + "GROUP BY idInventario ORDER by calificacion desc";

            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                inventarios.add(new Inventario_TO(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getInt(1), new Empresa_TO(rs.getInt(23))));
            }

        } catch (Exception e) {
            inventarios = new ArrayList<>();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return inventarios;
    }

    @Override
    public List<Inventario_TO> consultarJuguetesMasVotadosRangoGenero(int idEmpresa, String genero, int desde, int hasta) throws Exception {
        List<Inventario_TO> inventarios = new ArrayList<>();
        String sql = "";
        try {

            if (!genero.trim().equals("")) {
                sql = "SELECT SUM(vo.calificacion) AS Calificacion, vo.idInventario, inv.codigo, inv.nombre, inv.descripcion, inv.edadDesde, inv.edadHasta, "
                        + "  inv.genero, inv.cantidad, inv.url1, inv.url2, inv.url3, inv.url4, inv.url5, inv.url6, inv.url7, inv.url8, inv.url9, inv.url10, "
                        + "  inv.url11, inv.url12, inv.observacion, inv.idEmpresa "
                        + "  FROM votacion as vo, inventario as inv "
                        + "  where vo.idInventario=inv.idInventario and inv.status = 1 and inv.genero = '" + genero.trim() + "' AND inv.idEmpresa = '" + idEmpresa + "' and "
                        + " edadDesde >= " + desde + "  and " + hasta + "  >= edadHasta "
                        + " GROUP BY idInventario ORDER by calificacion desc";
            } else {
                sql = "SELECT SUM(vo.calificacion) AS Calificacion, vo.idInventario, inv.codigo, inv.nombre, inv.descripcion, inv.edadDesde, inv.edadHasta, "
                        + "  inv.genero, inv.cantidad, inv.url1, inv.url2, inv.url3, inv.url4, inv.url5, inv.url6, inv.url7, inv.url8, inv.url9, inv.url10, "
                        + "  inv.url11, inv.url12, inv.observacion, inv.idEmpresa "
                        + "  FROM votacion as vo, inventario as inv "
                        + "  where vo.idInventario=inv.idInventario and inv.status = 1 AND inv.idEmpresa = '" + idEmpresa + "' and "
                        + " edadDesde >= " + desde + "  and " + hasta + "  >= edadHasta "
                        + " GROUP BY idInventario ORDER by calificacion desc";
            }

            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                inventarios.add(new Inventario_TO(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getInt(1), new Empresa_TO(rs.getInt(23))));
            }

        } catch (Exception e) {
            inventarios = new ArrayList<>();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return inventarios;
    }
}
