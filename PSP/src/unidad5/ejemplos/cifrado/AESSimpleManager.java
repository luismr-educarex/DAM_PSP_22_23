package unidad5.ejemplos.cifrado;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/** Implementa la funcionalidad relativa a la generación de la clave a partir de la contraseña del usuario
 * (debe tener 16 bytes) y los métodos de cifrado y descifrado. Contiene los siguientes métodos:
 * - obtenerClave: Genera la clave de cifrado y descifrado a partir de la contraseña del usuario.
 * - cifrar: Cifra un String.
 * - descifrar: Descifra un String
 * */

public class AESSimpleManager {
	
	public static Key  obtenerClave(String password, int longitud) {
		//La longitud puede ser 16,24 o 32 bytes
		Key clave = new SecretKeySpec(password.getBytes(),0,longitud,"AES");
		
		return clave;
	}
	
	public static String cifrar(String textoEnClaro,Key key) throws Exception{
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte [] cipherText = cipher.doFinal(textoEnClaro.getBytes());
		
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public static String descifrar(String textoCifrado, Key key) throws Exception{
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		cipher.init(cipher.DECRYPT_MODE,key);
		byte[] textoPlano = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
		
		return new String(textoPlano);
	}

}
