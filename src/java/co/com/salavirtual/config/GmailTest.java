package co.com.salavirtual.config;

public class GmailTest {

    public static void main(String[] args) {
//        testConfigYSend();
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
