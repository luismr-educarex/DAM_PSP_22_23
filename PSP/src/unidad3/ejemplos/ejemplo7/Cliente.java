package unidad3.ejemplos.ejemplo7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
   
	public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
  
        // PASO 1:Crear el objeto socket para colocar los datos
        DatagramSocket ds = new DatagramSocket();
  
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
  
        // bucle while hasta que el usuario introduzca "adios"
        while (true)
        {
            String inp = sc.nextLine();
  
            // Convertir el String de entrada un array de bytes.
            buf = inp.getBytes();
  
            // PASO 2: Crear el datagramPacket para enviar los datos
            DatagramPacket DpSend =
                  new DatagramPacket(buf, buf.length, ip, 1234);
  
            // PASO 3: usar la función send para actualizar el envío de datos
            ds.send(DpSend);
  
            // terminar el bucle si se ha introducido "adios"
            if (inp.equals("adios"))
                break;
        }
    }
   
}