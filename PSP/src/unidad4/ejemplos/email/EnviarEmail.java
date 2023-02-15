package unidad4.ejemplos.email;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarEmail {
	
	public static void main(String[] args) {
	    String destinatario =  "luismr.tic@gmail.com"; //A quien le quieres escribir.
	    String asunto = "Correo de prueba enviado desde el equipo de Luis";
	    String cuerpo = "Esta es una prueba de correo desde Luis";

	    enviarConGMail(destinatario, asunto, cuerpo);
	}
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    
	    String remitente = "dam.modulos@gmail.com"; 

	    Properties props = System.getProperties();
	    /*
	    props.put("mail.smtp.clave", "cxfcpfxdmeykvnvl");    //La clave de la cuenta
	    */
	    props.put("mail.smtp.auth","true");  //Usar autenticaciónn mediante usuario y clave
		props.put("mail.smtp.host","smtp.gmail.com"); //El servidor SMTP de Google
		props.put("mail.smtp.port","587"); //El puerto SMTP seguro de Google
		props.put("mail.smtp.starttls.enable","true"); //Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); //versión del protocolo ssl
		props.put("mail.debug", "true");
	    
	    Session sesion = Session.getDefaultInstance(props);
	    MimeMessage mensaje = new MimeMessage(sesion);
	    
	    /*En Java, un BodyPart es una clase abstracta que forma parte de la API de JavaMail 
	     * y se utiliza junto con la clase Multipart para construir 
	     * y enviar mensajes de correo electrónico en formato MIME (Multipurpose Internet Mail Extensions)*/
	    BodyPart adjunto = new MimeBodyPart();
	    MimeMultipart multiParte = new MimeMultipart();

	    try {
	        mensaje.setFrom(new InternetAddress(remitente));
	        mensaje.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios destinatarios
	        mensaje.setSubject(asunto);
	        mensaje.setText(cuerpo);
	        
	        //Recuperamos el fichero adjunto, lo cambiamos de nombre y lo añadimos al mensaje
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/luism/Desktop/cursoFPDUAL.pdf")));
	        adjunto.setFileName("mifichero.pdf");
	        multiParte.addBodyPart(adjunto);
	        mensaje.setContent(multiParte);
	        
	        Transport transporte = sesion.getTransport("smtp");
	        transporte.connect("smtp.gmail.com", remitente, "cxfcpfxdmeykvnvl");
	        transporte.sendMessage(mensaje, mensaje.getAllRecipients());
	        transporte.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}

}
