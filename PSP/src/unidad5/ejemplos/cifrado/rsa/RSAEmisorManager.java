package unidad5.ejemplos.cifrado.rsa;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.Key;
import java.security.PrivateKey;

import javax.crypto.Cipher;

/**
 * Cifra un texto con la clave privada obtenida del fichero generado en ClavesManager.java
 * y almacena el resultado en un fichero. Esta clase deje ejecutarse en segundo lugar
 * @author luism
 *
 */
public class RSAEmisorManager {
	
	private static final String DATOS = "El código de acceso es 1513";
	
	private static byte[] cifrar(String mensaje,Key clave) throws Exception{
		Cipher encriptador = Cipher.getInstance("RSA");
		
		encriptador.init(Cipher.ENCRYPT_MODE,clave);
		byte[] mensajeBytes = mensaje.getBytes(StandardCharsets.UTF_8);
		
		byte[] mensajeCifradoBytes = encriptador.doFinal(mensajeBytes);
		
		return mensajeCifradoBytes;
	}
	
	public static void main(String[] args) {
		
		PrivateKey clavePrivada;
		File fichero = new File("datoscifrados.rsa");
		try {
			clavePrivada = ClavesManager.getClavePrivada();
			byte[] mensajeCifrado = cifrar(DATOS,clavePrivada);
			Files.write(fichero.toPath(),mensajeCifrado);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
