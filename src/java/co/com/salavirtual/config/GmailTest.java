package co.com.salavirtual.config;


import org.junit.Test;

public class GmailTest {

    public static void main(String[] args) {
        testConfigYSend();
    }

//    @Test
    public static void testSendDirecto(String login, String password, String to, String subject, String body) {
        Gmail.send(
                "login", login,
                "password", password,
                "to", to,
                "cc", "",
                "bcc", "",
                "subject", subject,
                "body", body
        );
    }

//    @Test
    public static void testConfigYSend() {
        //Esto quizas en el archivo de configuracion
        Gmail.config(
                "username", "sac.juguetes@gmail.com", //alias de login
                "pass", "sac.123456789", //alias de password
                "to", "cardenasg66@gmail.com",
                "cc", "chanerec@gmail.com",
                "bcc", "eymard@gmail.com"
        );
        //esto en donde se envia el correo previamente ya configurado los parametros
        Gmail.send(
                "title", "prueba de email",//alias de subject
                "msg", "<h1>Esto es una prueba de envio de correos</h1><p>exitosa!!</p>"
        );
    }
}
