package unidad4.ejemplos.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class DescargarFichero {

	public static void main(String[] args) throws IOException {
		
		FTPClient cliente = new FTPClient();
		
		String servFTP= "f27-preview.runhosting.com";
		
		System.out.println("Nos conectamos a: "+servFTP);

		String usuario = "4258683";
		String clave = "admin.1234";
		
		cliente.connect(servFTP);
		cliente.enterLocalPassiveMode();
		
		boolean login = cliente.login(usuario, clave);
		
		if(login) {
			System.out.println("Login correcto...");
		}else {
			
			System.out.println("Login incorrecto");
			cliente.disconnect();
			System.exit(1);
		}
		
		System.out.println("Directorio actual:"+cliente.printWorkingDirectory());
		
		FTPFile[] files = cliente.listFiles();
		System.out.println("Ficheros en el directorio actual:"+files.length);
		
		String tipos[] = {"Fichero","Directorio","Enlace simb."};
		
		for(int i = 0; i<files.length; i++) {
			System.out.println("\t"+files[i].getName()+"=>"+tipos[files[i].getType()]);
		}
		
		String direc="MIS_DATOS";
		
		cliente.changeWorkingDirectory(direc);
		
		/* ############################  */
		
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\luism\\Desktop\\datos\\TEMPERATURAS-nuevo.txt"));
		
		
		if(cliente.retrieveFile("TEMPERATURAS.txt", out)) {
				System.out.println("Recuperado correctamente");
		}else {
			System.out.println("No se ha podido descargar");
		}
		
		/* ############################  */
		
		out.close();
		
		
		boolean logout = cliente.logout();
		if(logout) {
			System.out.println("Logout del servidor FTP...");
		}else {
			System.out.println("Error al hacer Logout...");
		}
		
		cliente.disconnect();
		
		System.out.println("Conexi�n finalizada");
		

	}

}
