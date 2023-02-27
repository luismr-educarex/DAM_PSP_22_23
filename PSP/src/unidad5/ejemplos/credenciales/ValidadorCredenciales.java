package unidad5.ejemplos.credenciales;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
/**
 * Esta clase debe ejecutarse (dispone de un método main) para realizar la validación de las credenciales.
 * Solicita información del identificador y de la contreña del usuario, genera el resumen a través del método
 * getDigest de la clase HASHManager, recupera el resumen almacenado durante le registro y compara si ambos
 * resúmenes (el generado y el recuperado del fichero) son iguales mediante el método compararResumenes de la 
 * clsase HASHManager. 
 * Por último, muestra los dos resúmenes convertidos a formato hexadecimal mediante el método mostrarResumenHexadecimal
 */
public class ValidadorCredenciales {
	
	private static final String ENCODING_TYPE = "UTF-8";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce identificador (email):");
		String identificador = sc.nextLine();
		
		System.out.println("Introduce contraseña:");
		String password = sc.nextLine();
		
		try {
			byte[] resumen = HASHManager.getDigest(password.getBytes(ENCODING_TYPE));
			byte[] resumen_almacenado = Files.readAllBytes(new File(identificador+".credencial").toPath());
			
			if(HASHManager.compararResumenes(resumen,resumen_almacenado)) {
				System.out.println("Autorizado");
			}else {
				System.out.println("Error de validación");
			}
			mostrarResumenHexadecimal(resumen);
			mostrarResumenHexadecimal(resumen_almacenado);
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	private static void mostrarResumenHexadecimal(byte[] resumen) {
		String resumenHexadecimal = String.format("%064x", new BigInteger(1,resumen));
		System.out.println(resumenHexadecimal);
	}
}
