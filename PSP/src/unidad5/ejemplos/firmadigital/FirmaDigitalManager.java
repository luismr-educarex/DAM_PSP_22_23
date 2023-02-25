package unidad5.ejemplos.firmadigital;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

/**
 * Esta clase es la que se encarga de generar la firma y verificarla. Utiliza las claves privadas
 * y p�blicas generadas con ClavesManager. En el c�digo de esta soluci�n, el mensaje original y el mensaje
 * modificado tienen diferencias, por lo que el resultado de la verificaci�n de la firma ser� negativo
 * debido a la falta de integridad.
 *
 */
public class FirmaDigitalManager {

	private static String MENSAJE_ORIGINAL = "El n�mero premiado es el 23";
	private static String MENSAJE_MODIFICADO = "El n�mero premiado es el 32";
	
	public static void main(String[] args) {
		
		try {
			Signature sign = Signature.getInstance("DSA");
			sign.initSign(ClavesManager.getClavePrivada());
			sign.update(MENSAJE_ORIGINAL.getBytes());
			byte[] firma = sign.sign();
			
			sign.initVerify(ClavesManager.getClavePublica());
			sign.update(MENSAJE_MODIFICADO.getBytes());
			
			if(sign.verify(firma)) {
				System.out.println("Mensaje verificado");
			}else {
				System.err.println("Atenci�n:el mensaje no es fiable");
			}
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
