package unidad5.ejemplos.algoritmoshash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConvertidorSHA512 {
	
	public String convertirSHA512(String password) {
		
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
	}

}
