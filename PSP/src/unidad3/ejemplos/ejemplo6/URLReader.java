package unidad3.ejemplos.ejemplo6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
  public static void main(String[] args) throws Exception {
    URL pcgull = new URL("https://ciclos.neocities.org/fichero.txt");
    BufferedReader in = new BufferedReader( new InputStreamReader(pcgull.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);

    in.close();
  }
}