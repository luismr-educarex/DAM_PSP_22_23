package unidad1.ejemplos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjecutarProcesos {

    public static void main(String[] args) {
        try {
            String comando = "/home/mint/Escritorio/crearUsuario.sh";
            
            String usuario = "usuario";
            String password = "password";
            
            ProcessBuilder pb = new ProcessBuilder(comando, usuario,password);
            pb.redirectErrorStream(true);
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();
            System.out.println("El script ha sido ejecutado. Código de salida: " + codigoSalida);
            InputStream is = proceso.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

