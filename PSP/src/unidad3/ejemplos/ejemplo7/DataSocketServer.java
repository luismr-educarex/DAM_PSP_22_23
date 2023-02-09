package unidad3.ejemplos.ejemplo7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
   
public class DataSocketServer 
{
	public static void main(String[] args) throws IOException
    {
        // PASO 1: Crear un socket para escuchar en el puerto 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] recepcion = new byte[65535]; // buffer
  
        DatagramPacket DpRececpcion = null;
        while (true)
        {
  
            // Paso 2: crear un a DatgramPacket para recibir los datos.
            DpRececpcion = new DatagramPacket(recepcion, recepcion.length);
  
            // Paso 3: recibir los datos del buffer.
            ds.receive(DpRececpcion);
  
            System.out.println("Cliente:-" + convertirACadena(recepcion));
  
            // Termina el servidor si el cliente envía "adios"
            if (convertirACadena(recepcion).toString().equals("adios"))
            {
                System.out.println("Cliente enviado adios......SALIENDO");
                break;
            }
  
            // Limpiamos el buffer despés de cada mensaje.
            recepcion = new byte[65535];
        }
    }
  
    // Método para convertir el array byte de datos a una cadena
    public static StringBuilder convertirACadena(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder resultado = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
        	resultado.append((char) a[i]);
            i++;
        }
        return resultado;
    }
}
   
