package unidad4.ejemplos.email;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GestorEmail {
	
	private Properties propiedades;
	private Session sesion;
	
	private void setPropiedadesServidorSMTP(){
		propiedades = System.getProperties();
		propiedades.put("mail.smtp.auth","true");
		propiedades.put("mail.smtp.host","smtp.gmail.com");
		propiedades.put("mail.smtp.port","587");
		propiedades.put("mail.smtp.starttls.enable","true");
		propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
		propiedades.put("mail.debug", "true");
		sesion=Session.getInstance(propiedades,new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		    	return new PasswordAuthentication("dam.modulos@gmail.com", "cxfcpfxdmeykvnvl");
		    }
		
		});
			
	}

	
	private Transport conectarServidorSMTP(String direccionEmail,String password)
	throws NoSuchProviderException,MessagingException{
		
		//Una vez construido el mensaje utilizamos la clase Transport para enviarlo, normalmente a través del protocolo SMTP
		Transport t= (Transport) sesion.getTransport("smtp");
		t.connect(propiedades.getProperty("mail.smtp.host"),direccionEmail,password);
		
		return t;
	}
	
	private Message crearNucleoMensaje(String emisor,String destinatario, String asunto)
	throws AddressException, MessagingException{
		// Message permite constuir mensajes con todos sus atributos
		// MimeMenssage es una subclase de Message que permite especificar tipos MIME 
		Message mensaje = new MimeMessage(sesion); 
		mensaje.setFrom(new InternetAddress(emisor));
		mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
		mensaje.setSubject(asunto);
		
		return mensaje;
	}
	
	private Message crearMensajeTexto(String emisor, String destinatario, String asunto, String textoMensaje)
	throws MessagingException,AddressException,IOException{
			Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
			mensaje.setText(textoMensaje);
			return mensaje;
					
	}
	
	private Message crearMensajeConAdjunto(String emisor,String destinatario, String asunto, String textoMensaje, String pathFichero)
	throws MessagingException, AddressException, IOException{
		Message mensaje = crearNucleoMensaje(emisor,destinatario,asunto);
		//Cuerpo del mensaje
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(textoMensaje);
		//Adjunto del mensaje
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.attachFile(new File(pathFichero));
		//Composición del mensaje (Cuerpo + Adjunto)
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		multipart.addBodyPart(mimeBodyPart);
		mensaje.setContent(multipart);
		return mensaje;
	}
	
	public void enviarMensajeTexto(String emisor, String destinatario, String asunto, String textoMensaje,
			String direccionEmail, String password) throws AddressException, MessagingException, IOException{
		
		setPropiedadesServidorSMTP();
		Message mensaje = crearMensajeTexto(emisor, destinatario, asunto, textoMensaje);
		//Una vez construido el mensaje utilizamos la clase Transport para enviarlo
		Transport t = conectarServidorSMTP(direccionEmail, password);
		
		t.send(mensaje, mensaje.getAllRecipients());
		
		t.close();
		
		return;
	
	}
	
	
	public void enviarMensajeConAdjunto(String emisor, String destinatario, String asunto, String textoMensaje,String pathFichero,
			String direccionEmail, String password) throws AddressException, MessagingException, IOException{
		setPropiedadesServidorSMTP();
		Message mensaje = crearMensajeConAdjunto(emisor, destinatario, asunto,textoMensaje,pathFichero);
		Transport t = conectarServidorSMTP(direccionEmail,password);
		
		t.sendMessage(mensaje, mensaje.getAllRecipients());
		
		t.close();
		
		return;
	}
	
	public static void main(String[] args) {
		
		
		try {
			/*Scanner sc = new Scanner(System.in);
			System.out.println("Introduce dirección de correo");
			String emailEmisor = sc.nextLine();
			System.out.println("Introduce contraseña");
			String passwordEmisor = sc.nextLine();
			sc.close();
			*/
			String emailEmisor="dam.modulos@gmail.com";
			String passwordEmisor="cxfcpfxdmeykvnvl";		
			GestorEmail gestorEmail = new GestorEmail();
			gestorEmail.enviarMensajeTexto(emailEmisor, 
										  "luismr.tic@gmail.com", 
										  "Aviso tarea", 
										  "Tiene mañana una tarea para PSP", 
										  emailEmisor, passwordEmisor);
			
			gestorEmail.enviarMensajeConAdjunto(emailEmisor, 
					  "luismr.tic@gmail.com", 
					  "Aviso curso", 
					  "Hay disponible un curso de FP DUAL",
					  "C:/Users/luism/Desktop/cursoFPDUAL.pdf",
					  emailEmisor, passwordEmisor);
			System.out.println("Correo enviado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
