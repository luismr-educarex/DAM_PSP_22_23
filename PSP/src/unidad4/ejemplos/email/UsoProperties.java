package unidad4.ejemplos.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UsoProperties {

	public static void main(String[] args) {
		
		Properties properties= new Properties();
	    try {
	    	
	      properties.load(new FileInputStream(new File("configuracion.properties")));
	        //Este fichero si no está en una ruta concreta del sistema, debe colgar del directorio raíz del proyecto.
	    	/**CONTENIDO DEL FICHERO___________
	    	   remitente=dam.modulos@gmail.com
			   password=cxfcpfxdmeykvnvl
	    	 */
	      
	      System.out.println(properties.get("remitente"));
	      System.out.println(properties.get("password"));
	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

	}

}
