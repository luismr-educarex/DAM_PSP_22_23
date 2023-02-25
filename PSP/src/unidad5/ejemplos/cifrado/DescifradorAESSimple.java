package unidad5.ejemplos.cifrado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
/**
 * Contiene un método main que genera la clave, lee el contenido de un fichero y lo descifra.
 */
public class DescifradorAESSimple {

	public static void main(String[] args) {
		
		final int LONGITUD_BLOQUE = 16; // Expresado en bytes
		final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
		final String PASSWORD = "MeLlamoSpiderman";
		
		try {
			File fichero = new File(NOMBRE_FICHERO);
			Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
			
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String textoCifrado = br.readLine();
			String textoEnClaro  = AESSimpleManager.descifrar(textoCifrado, clave);
			br.close();
			
			System.out.println("El texto descifrado es:"+textoEnClaro);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
