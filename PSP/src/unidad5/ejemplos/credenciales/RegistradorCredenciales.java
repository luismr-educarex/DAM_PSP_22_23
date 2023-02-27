package unidad5.ejemplos.credenciales;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Esta clase debe ejecutarse (dispone de un método main) para realizar el registro de las credenciales.
 * Solicita la introducción del identificador y de la contraseña del usuario, genera el resumen a través del método
 * getDigest de la clase HASHManager y lo almacena en un fichero. Además, muestra el resumen convertido en formato
 * hexadecimal mediante el método mostrarResumenHexadecimal.
 */
public class RegistradorCredenciales {
	
	private static final String ENCODING_TYPE = "UTF-8";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce identificador (email):");
		String identificador = sc.nextLine();
		
		System.out.println("Introduce contraseña:");
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
