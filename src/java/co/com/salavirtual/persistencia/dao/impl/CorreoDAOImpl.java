/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.salavirtual.persistencia.dao.impl;

import co.com.salavirtual.config.GmailTest;
import co.com.salavirtual.modelo.dto.Empresa_TO;
import co.com.salavirtual.modelo.dto.Inventario_TO;
import co.com.salavirtual.modelo.dto.Pedido_TO;
import co.com.salavirtual.modelo.dto.Usuario_TO;
import co.com.salavirtual.persistencia.dao.CorreoDAO;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Desarrollo_Planit
 */
public class CorreoDAOImpl implements CorreoDAO {

    private final Properties properties = new Properties();
    private Session session;

    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");

//    private void init() {
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
////        properties.setProperty("mail.smtp.starttls.enable", "true");
////        properties.setProperty("mail.smtp.port", "587");
//        properties.put("mail.smtp.socketFactory.port", "465");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.port", "465");
//        properties.put("mail.smtp.user", "sac.juguetes@gmail.com"); //Correo desde donde se enviaran lo mails
//        
//        session = Session.getDefaultInstance(properties);
//        session.setDebug(true);
//
//    }
    @Override
    public int enviarMensajeBienvenido() {

//        GmailTest.testSendDirecto();
        return 0;
    }

    @Override
    public int correoCreacionAdministrador(Usuario_TO usuario, Empresa_TO empresa) {
        int valor = 0;

        System.out.print(usuario.toString() + " " + empresa.toString());

        String login = "sac.juguetes@gmail.com";
        String password = "sac.123456789";
        String to = usuario.getEmail();
        String subject = "Nuevo Usuario Administrador";
        String body = "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-8\">\n"
                + "		<meta name=\"viewport\" content=\"width=device-width, user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum=1.0\">\n"
                + "		\n"
                + "		<title></title>\n"
                + "	</head>\n"
                + "	\n"
                + "	<body>\n"
                + "			<center>\n"
                + "			<header>\n"
                + "			<div class=\"contenido\" align=\"left\">	\n"
                + "			<br>Buenos días: " + usuario.getNombre() + " </br>\n"
                + "		    <br> El siguiente mensaje de correo es para informar que su acceso a la sala virtual ha sido creado.</br>\n"
                + "		    <br> Haga click o copie el siguiente enlace para acceder a su sala virtual:</br>\n"
                + "		    <br>\n"
                + "		    www.XXXXXXXXX .com\n"
                + "		    <br>\n"
                + "		    <br>\n"
                + "		    Sus datos de acceso son: <br><br>\n"
                + "			Usuario: " + usuario.getUsuario() + "<br>\n"
                + "			Login: " + usuario.getContrasena() + "\n"
                + "			<br>\n"
                + "		    <br>\n"
                + "		   <div class=\"texto\">\n"
                + "		  \n"
                + "		<fieldset>   <br><h4>Con estos datos tendrá acceso al entorno de la Sala virtual de " + empresa.getNombre() + " allí podrá consultar todo lo pertinente al proceso de selección de regalos; donde tendrá acceso a diversas funciones como:  <br>\n"
                + "\n"
                + "			  <br>Monitorear el proceso de votación y calificación de la pre-selección de regalos por parte del comité evaluador (en caso de haber solicitado este servicio)  <br>\n"
                + "\n"
                + "			  <br>Confirmar la selección de productos escogidos y que se presentan para los hijos de sus colaboradores en cada rango de edad y género  <br>\n"
                + "\n"
                + "			  <br>Podrá acceder a diferentes reportes que le permitirán hacer seguimiento al proceso de selección de sus colaboradores: regalo más escogido en   general, regalo más votado por rango de edad y género, cantidad de personas que ya han hecho su selección y cuales no. Enviar notificaciones para invitar o recordar a sus afiliados seleccionar su(s) regalos; entre otras funciones. </h4> <br>\n"
                + "			  </div>\n"
                + "			</fieldset>\n"
                + "			  </div>\n"
                + "			  <footer>\n"
                + "			  	<h5>\n"
                + "			  		Cualquier duda o inquietud no dude en contactar a su Ejecutivo de cuenta, o puede comunicarse al área de Soporte al Cliente a través de los siguientes medios:<br> Correo electrónico: sac.juguetes@distribuidoraelfaro.co<br>	Celular: 3186619233\n"
                + "			  	</h5>\n"
                + "			  </footer>	\n"
                + "			\n"
                + "			</header>\n"
                + "			</center>\n"
                + "	</body>\n"
                + "					<style type=\"text/css\">\n"
                + "						body{\n"
                + "							font-family: arial;\n"
                + "							background-color: gray 800px;\n"
                + "						    margin-top:80px;\n"
                + "							padding:90px;\n"
                + "							}\n"
                + "						.contenido{\n"
                + "\n"
                + "							align-content: left;\n"
                + "							size: 600px 800px;\n"
                + "							background-color: rgba(245, 237, 200, 0.33);\n"
                + "							}\n"
                + "						.texto{\n"
                + "							font-family: cursive;\n"
                + "						}	\n"
                + "						h5{\n"
                + "							text-shadow: 3em;\n"
                + "						}\n"
                + "					</style>\n"
                + "</html>";

        GmailTest.testSendDirecto(login, password, to, subject, body);

        return valor;
    }

    @Override
    public int correoCreacionComite(Usuario_TO usuario, Empresa_TO empresa) {
        int valor = 0;

        String login = "sac.juguetes@gmail.com";
        String password = "sac.123456789";
        String to = usuario.getEmail();
        String subject = "Nuevo Usuario Comite";
        String body = "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-8\">\n"
                + "		<meta name=\"viewport\" content=\"width=device-width, user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum=1.0\">\n"
                + "		\n"
                + "		<title></title>\n"
                + "	</head>\n"
                + "	\n"
                + "	<body>\n"
                + "			<center>\n"
                + "			<header>\n"
                + "			<div class=\"contenido\" align=\"left\">	\n"
                + "			<br>Buenos días:" + usuario.getNombre() + "</br>\n"
                + "		    <br> El siguiente mensaje de correo es para informar que su acceso a la sala virtual ha sido creado. </br>\n"
                + "		    <br> Haga click o copie el siguiente enlace para acceder a su sala virtual:</br>\n"
                + "		    <br>\n"
                + "		    www.XXXXXXXXX .com\n"
                + "		    <br>\n"
                + "		    <br>\n"
                + "		    Sus datos de acceso son: <br><br>\n"
                + "			Usuario: " + usuario.getUsuario() + "<br>\n"
                + "			password: " + usuario.getContrasena() + "\n"
                + "			<br>\n"
                + "		    <br>\n"
                + "		   <div class=\"texto\">\n"
                + "		  \n"
                + "		<fieldset>   <br><h4>Con estos datos tendrá acceso al entorno de la Sala virtual de " + empresa.getNombre() + " allí podrá consultar todo lo pertinente al proceso de selección de regalos; donde tendrá acceso a diversas funciones como:  <br>\n"
                + "\n"
                + "			  <br>Monitorear el proceso de votación y calificación de la pre-selección de regalos por parte del comité evaluador (en caso de haber solicitado este servicio) <br>\n"
                + "\n"
                + "			  <br>Confirmar la selección de productos escogidos y que se presentan para los hijos de sus colaboradores en cada rango de edad y género <br>\n"
                + "\n"
                + "			  <br>Podrá acceder a diferentes reportes que le permitirán hacer seguimiento al proceso de selección de sus colaboradores: regalo más escogido en general, regalo más votado por rango de edad y género, cantidad de personas que ya  han hecho su selección y cuales no. Enviar notificaciones para invitar o recordar a sus afiliados seleccionar su(s) regalos; entre otras funciones. </h4> <br>\n"
                + "			  </div>\n"
                + "			</fieldset>\n"
                + "			  </div>\n"
                + "			  <footer>\n"
                + "			  	<h5>\n"
                + "			  		Cualquier duda o inquietud no dude en contactar a su Ejecutivo de cuenta, o puede comunicarse al área de Soporte al Cliente a través de los siguientes medios:<br> Correo electrónico: sac.juguetes@distribuidoraelfaro.co<br>	Celular: 3186619233\n"
                + "			  	</h5>\n"
                + "			  </footer>	\n"
                + "			\n"
                + "			</header>\n"
                + "			</center>\n"
                + "	</body>\n"
                + "					<style type=\"text/css\">\n"
                + "						body{\n"
                + "							font-family: arial;\n"
                + "							background-color: gray 800px;\n"
                + "						    margin-top:80px;\n"
                + "							padding:90px;\n"
                + "							}\n"
                + "						.contenido{\n"
                + "\n"
                + "							align-content: left;\n"
                + "							size: 600px 800px;\n"
                + "							background-color: rgba(245, 237, 200, 0.33);\n"
                + "							}\n"
                + "						.texto{\n"
                + "							font-family: cursive;\n"
                + "						}	\n"
                + "						h5{\n"
                + "							text-shadow: 3em;\n"
                + "						}\n"
                + "					</style>\n"
                + "</html>";

        GmailTest.testSendDirecto(login, password, to, subject, body);

        return valor;
    }

    @Override
    public int correoVotacion(Usuario_TO usuario, Empresa_TO empresa) {
        int valor = 0;

        System.out.print(usuario.toString() + " " + empresa.toString());

        String login = "sac.juguetes@gmail.com";
        String password = "sac.123456789";
        String to = usuario.getEmail();
        String subject = "Votacion Juguetes";
        String body = "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-8\">\n"
                + "		<meta name=\"viewport\" content=\"width=device-width, user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum=1.0\">\n"
                + "		\n"
                + "		<title></title>\n"
                + "	</head>\n"
                + "	\n"
                + "	<body>\n"
                + "			<center>\n"
                + "			<header>\n"
                + "			<div class=\"contenido\" align=\"left\">	\n"
                + "			<br>Buenos días: " + usuario.getNombre() + " </br>\n"
                + "		    <br> El siguiente mensaje de correo es para informar que su acceso a la sala virtual para la votación de regalos por parte del comité de " + empresa.getNombre() + " ha sido creado. </br>\n"
                + "		    <br> Haga click o copie el siguiente enlace para acceder a su sala virtual:</br>\n"
                + "		    <br>\n"
                + "		    www.XXXXXXXXX .com\n"
                + "		    <br>\n"
                + "		    <br>\n"
                + "		    Sus datos de acceso son: <br><br>\n"
                + "			Usuario: " + usuario.getUsuario() + "<br>\n"
                + "			Contraseña: " + usuario.getContrasena() + "\n"
                + "			<br>\n"
                + "		    <br>\n"
                + "		   <div class=\"texto\">\n"
                + "		  \n"
                + "		<fieldset>   <br><h4>Con estos datos tendrá acceso al entorno de la Sala virtual de " + empresa.getNombre() + " donde usted como parte del comité de selección de regalos podrá visualizar y votar por cada una de las opciones que allí se presentan para los diferentes rangos de edad en cada género.  <br>\n"
                + "\n"
                + "			  <br>Por favor, otorgue su puntuación a cada una de las referencias allí presentadas; recuerde que la felicidad y la satisfacción de los colaboradores de " + empresa.getNombre() + "  y sus hijos es responsabilidad nuestra.  <br>\n"
                + "\n"
                + "			   <br>Podrá acceder a diferentes reportes que le permitirán hacer seguimiento al proceso de selección de sus colaboradores: regalo más escogido en   general, regalo más votado por rango de edad y género, cantidad de personas que ya han hecho su selección y cuales no. Enviar notificaciones para invitar o recordar a sus afiliados seleccionar su(s) regalos; entre otras funciones. </h4> <br>\n"
                + "			  </div>\n"
                + "			</fieldset>\n"
                + "			  </div>\n"
                + "			  <footer>\n"
                + "			  	<h5>\n"
                + "			  		Cualquier duda o inquietud no dude en comunicarse al área de Soporte al Cliente; allí daremos solución a todas sus dudas o inconvenientes. Puede contactarnos a través de los siguientes medios: <br> Correo electrónico: sac.juguetes@distribuidoraelfaro.co<br>	Celular: 3186619233\n"
                + "			  	</h5>\n"
                + "			  </footer>	\n"
                + "			\n"
                + "			</header>\n"
                + "			</center>\n"
                + "	</body>\n"
                + "					<style type=\"text/css\">\n"
                + "						body{\n"
                + "							font-family: arial;\n"
                + "							background-color: gray 800px;\n"
                + "						    margin-top:80px;\n"
                + "							padding:90px;\n"
                + "							}\n"
                + "						.contenido{\n"
                + "\n"
                + "							align-content: left;\n"
                + "							size: 600px 800px;\n"
                + "							background-color: rgba(245, 237, 200, 0.33);\n"
                + "							}\n"
                + "						.texto{\n"
                + "							font-family: cursive;\n"
                + "						}	\n"
                + "						h5{\n"
                + "							text-shadow: 3em;\n"
                + "						}\n"
                + "					</style>\n"
                + "</html>";

        GmailTest.testSendDirecto(login, password, to, subject, body);

        return valor;

    }

    @Override
    public int correoConfirmacionSeleccionJuguete(Usuario_TO usuario, Inventario_TO inventario, Pedido_TO pedido) {
        int valor = 0;

        String login = "sac.juguetes@gmail.com";
        String password = "sac.123456789";
        String to = usuario.getEmail();
        String subject = "Confirmacion Seleccion Juguetes";
        String body = "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-8\">\n"
                + "		<meta name=\"viewport\" content=\"width=device-width, user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum=1.0\">\n"
                + "		\n"
                + "		<title></title>\n"
                + "	</head>\n"
                + "	\n"
                + "	<body>\n"
                + "			<center>\n"
                + "			<header>\n"
                + "			<div class=\"contenido\" align=\"left\">	\n"
                + "			<br>Buenos días: " + usuario.getNombre() + " </br>\n"
                + "		    <br>El siguiente mensaje es para confirmar su elección de regalo para su hijo(a) " + pedido.getNombreHijo() + "  en la sala virtual. </br>\n"
                + "		    <h2>Regalo Seleccionado:  " + inventario.getCodigo() + " " + inventario.getNombre() + " </h2>\n"
                + "		    <br>\n"
                + "		    <div class=\"relagalo\" align=\"center\"    >\n"
                + "		    </div>\n"
                + "		   <div class=\"texto\">\n"
                + "		  \n"
                + "			<fieldset>   <br><h4>Por favor imprimir y Presentar el siguiente comprobante para poder reclamar su presente.  <br>\n"
                + "						<br><h3>Código Único del Regalo: " + pedido.getTicket() + " </h3>\n"
                + "			 </div>\n"
                + "			</fieldset>\n"
                + "			  </div>\n"
                + "			  <footer>\n"
                + "			   	<!--	<h5>\n"
                + "			  		Cualquier duda o inquietud respecto al acceso o al uso de la Sala Virtual  no dude en comunicarse al área de Soporte al Cliente; allí daremos solución a todas sus dudas o inconvenientes. Puede contactarnos a través de los siguientes medios:  <br> Correo electrónico: sac.juguetes@distribuidoraelfaro.co<br>	Celular: 3186619233\n"
                + "			  	</h5>-->\n"
                + "			  </footer>	\n"
                + "			\n"
                + "			</header>\n"
                + "			</center>\n"
                + "	</body>\n"
                + "					<style type=\"text/css\">\n"
                + "						body{\n"
                + "							font-family: arial;\n"
                + "							background-color: gray 800px;\n"
                + "						    margin-top:80px;\n"
                + "							padding:90px;\n"
                + "							}\n"
                + "						.contenido{\n"
                + "\n"
                + "							align-content: left;\n"
                + "							size: 600px 800px;\n"
                + "							background-color: rgba(245, 237, 200, 0.33);\n"
                + "							}\n"
                + "						.texto{\n"
                + "							font-family: cursive;\n"
                + "						}	\n"
                + "						h5{\n"
                + "							text-shadow: 3em;\n"
                + "							\n"
                + "						}\n"
                + "						.regalo{\n"
                + "							position: absolute;\n"
                + "						}\n"
                + "					</style>\n"
                + "</html>";

        GmailTest.testSendDirecto(login, password, to, subject, body);

        return valor;

    }

    @Override
    public int correoSeleccionJuguete(Usuario_TO usuario, Empresa_TO empresa) {
        int valor = 0;

        String login = "sac.juguetes@gmail.com";
        String password = "sac.123456789";
        String to = usuario.getEmail();
        String subject = "Seleccion Juguetes";
        String body = "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-8\">\n"
                + "		<meta name=\"viewport\" content=\"width=device-width, user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum=1.0\">\n"
                + "		\n"
                + "		<title></title>\n"
                + "	</head>\n"
                + "	\n"
                + "	<body>\n"
                + "			<center>\n"
                + "			<header>\n"
                + "			<div class=\"contenido\" align=\"left\">	\n"
                + "			<br>Buenos días: " + usuario.getNombre() + "</br>\n"
                + "		    <br>El siguiente mensaje de correo es para informar que su acceso a la sala virtual para la elección del regalo de XXXXXXXX(Nombre del hijo o hija), XXXXXXXX(nombre del segundo hijo o hija si lo tiene; debe nombrar N cantidad de hijos que tiene esa persona) se encuentra habilitado.  </br>\n"
                + "		    <br> Haga click o copie el siguiente enlace para acceder a su sala virtual:</br>\n"
                + "		    <br>\n"
                + "		    www.XXXXXXXXX .com\n"
                + "		    <br>\n"
                + "		    <br>\n"
                + "		    Sus datos de acceso son: <br><br>\n"
                + "			Usuario: " + usuario.getUsuario() + " <br>\n"
                + "			Login: " + usuario.getContrasena() + " \n"
                + "			<br>\n"
                + "		    <br>\n"
                + "		   <div class=\"texto\">\n"
                + "		  \n"
                + "			<fieldset>   <br><h4>Con estos datos tendrá acceso al entorno de la Sala virtual de " + empresa.getNombre() + " donde podrá hacer su selección. Para nosotros es muy importante la satisfacción y felicidad de su(s) Hijo(s) y su familia. <br>\n"
                + "			 </div>\n"
                + "			</fieldset>\n"
                + "			  </div>\n"
                + "			  <footer>\n"
                + "			  	<h5>\n"
                + "			  		Cualquier duda o inquietud respecto al acceso o al uso de la Sala Virtual  no dude en comunicarse al área de Soporte al Cliente; allí daremos solución a todas sus dudas o inconvenientes. Puede contactarnos a través de los siguientes medios:  <br> Correo electrónico: sac.juguetes@distribuidoraelfaro.co<br>	Celular: 3186619233\n"
                + "			  	</h5>\n"
                + "			  </footer>	\n"
                + "			\n"
                + "			</header>\n"
                + "			</center>\n"
                + "	</body>\n"
                + "					<style type=\"text/css\">\n"
                + "						body{\n"
                + "							font-family: arial;\n"
                + "							background-color: gray 800px;\n"
                + "						    margin-top:80px;\n"
                + "							padding:90px;\n"
                + "							}\n"
                + "						.contenido{\n"
                + "\n"
                + "							align-content: left;\n"
                + "							size: 600px 800px;\n"
                + "							background-color: rgba(245, 237, 200, 0.33);\n"
                + "							}\n"
                + "						.texto{\n"
                + "							font-family: cursive;\n"
                + "						}	\n"
                + "						h5{\n"
                + "							text-shadow: 3em;\n"
                + "\n"
                + "						}\n"
                + "					</style>\n"
                + "</html>";

        
        GmailTest.testSendDirecto(login, password, to, subject, body);
        
        return valor;

    }

}
