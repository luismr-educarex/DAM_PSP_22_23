package unidad5.ejemplos.credenciales;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Esta clase debe ejecutarse (dispone de un m�todo main) para realizar el registro de las credenciales.
 * Solicita la introducci�n del identificador y de la contrase�a del usuario, genera el resumen a trav�s del m�todo
 * getDigest de la clase HASHManager y lo almacena en un fichero. Adem�s, muestra el resumen convertido en formato
 * hexadecimal mediante el m�todo mostrarResumenHexadecimal.
 */
public class RegistradorCredenciales {
	
	private static final String ENCODING_TYPE = "UTF-8";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce identificador (email):");
		String identificador = sc.nextLine();
		
		System.out.println("Introduce contrase�a:");
		String password = sc.nextLine();
		
		try {
			  byte[] resumen = HASHManager.getDigest(password.getBytes(ENCODING_TYPE));
			  Files.write(new File(identificador+".credencial").toPath(),resumen);
			  mostrarResumenHexadecimal(resumen);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();

	}
	
	private static void mostrarResumenHexadecimal(byte[] resumen) {
		String resumenHexadecimal = String.format("%064x", new BigInteger(1,resumen));
		System.out.println(resumenHexadecimal);
	}

}
