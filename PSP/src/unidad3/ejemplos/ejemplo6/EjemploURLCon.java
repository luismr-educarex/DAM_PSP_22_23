package unidad3.ejemplos.ejemplo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EjemploURLCon {

	public static void main(String[] args) {
		
		URL url=null;
		URLConnection urlCon=null;
		
		try {
			url = new URL("http://localhost/psp/comprobarMayorEdad.php");
			urlCon=url.openConnection();
			//Permite que el usuario envíe datos si el parámetro es true. Por defecto = true.
			urlCon.setDoOutput(true);
			
			String cadena="anio=2006";
			
			//ESCRIBIR LA URL CON LOS PARÁMETROS
			PrintWriter salida= new PrintWriter(urlCon.getOutputStream());
			salida.write(cadena);
			salida.close(); //cerrar el flujo
			
			BufferedReader in;
			InputStream entrada = urlCon.getInputStream();
			in = new BufferedReader(new InputStreamReader(entrada));
			
			String linea;
			while((linea=in.readLine())!=null) {
				System.out.println(linea);
			}
			
			in.close();
			
		}
		catch(MalformedURLException e) {
			System.err.println("URL mal formada:"+e);
		}
		catch(IOException e) {
			System.err.println("Error IO"+ e);
		}

	}

}
