package co.com.salavirtual.config;

public class GmailTest {

    public static void main(String[] args) {
//        testConfigYSend();
    }

//    @Test
    public static void testSendDirecto(String login, String password, String to, String subject, String body) {
        Gmail.send(
                "login", login.trim(),
                "password", password.trim(),
                "to", to.trim(),
//                "cc", to.trim(),
//                "bcc",to.trim(),
                "subject", subject,
                "body", body
//                 "body", "<h1>Esto es una prueba de envio de correos</h1><p>exitosa!!</p>"
        );
    }

    public static void testSendDirecto2() {
        Gmail.send(
                "login","sac.juguetes@gmail.com",
                "password", "sac.123456789",
                "to", "cardenasg66@gmail.com",
                "cc", "cardenasg66@gmail.com",
                "bcc", "cardenasg66@gmail.com",
                "subject", "Nuevo Usuario Administrador",
                "body", "<h1>Esto es una prueba de envio de correos</h1><p>exitosa!!</p>"
                
  
        );
    }

//    @Test
    public static void testConfigYSend(String login, String password, String to, String subject, String body) {
        //Esto quizas en el archivo de configuracion
        Gmail.config(
                "username", login.trim(), //alias de login
                "pass", password.trim(), //alias de password
                "to", to.trim(),
                "cc", "",
                "bcc", ""
        );
        //esto en donde se envia el correo previamente ya configurado los parametros
        Gmail.send(
                "title", subject,//alias de subject
                "msg", body
        );
    }
}
