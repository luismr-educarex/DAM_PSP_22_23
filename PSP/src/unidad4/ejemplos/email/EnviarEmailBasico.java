package unidad4.ejemplos.email;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*Este ejemplo configura un MimeMessage usando la API de JavaMail
 *y lo envía a través de una cuenta de Gmail usando la autenticación SMTP. 
 *El mensaje de correo electrónico contiene un asunto, 
 *un destinatario y contenido de texto*/

public class EnviarEmailBasico {
   public static void main(String[] args) throws Exception {
      // Establecer las propiedades del email
      String host = "smtp.gmail.com";
      String username = "dam.modulos@gmail.com";
      String password = "cxfcpfxdmeykvnvl";

      // Crear una sesión
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");
      Session session = Session.getInstance(props, new Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      // Crear el mensaje
      /*
       * Un MimeMessage es una subclase de javax.mail.Message que representa 
       * un mensaje de correo electrónico utilizando el formato MIME (Multipurpose Internet Mail Extensions). 
       * La clase MimeMessage proporciona métodos para configurar y 
       * recuperar varios atributos de mensajes de correo electrónico, 
       * como el remitente, el destinatario, el asunto, el contenido y los archivos adjuntos.*/
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("dam.modulos@gmail.com"));
      message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse("luismr.tic@gmail.com"));
      message.setSubject("Bienvenido a PSP");
      message.setText("Este es un correo para saludarte.");

      // Enviar el mensaje
      Transport.send(message);
      System.out.println("Email enviado con éxito.");
   }
}
