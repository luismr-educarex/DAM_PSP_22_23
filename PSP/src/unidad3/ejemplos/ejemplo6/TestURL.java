package unidad3.ejemplos.ejemplo6;


import java.net.*;

class  TestURL {
  public static void main( String[] args ) {
   
	  TestURL obj = new TestURL();
   
    try {
      System.out.println( "Constructor simple para URL principal" );
      obj.mostrar( new URL( "https://www.educarex.es/fp/ciclos-grados-medio-superior.html" ) );

      System.out.println( "Constructor de cadena para URL + directorio" );
      obj.mostrar( new URL( "https://www.educarex.es/fp" ) );

      System.out.println( "Constructor con protocolo, host y directorio" );
      obj.mostrar( new URL("http","www.educarex.es","/fp" ) );

      System.out.println( "Constructor con protocolo, host, puerto y directorio" );
      obj.mostrar( new URL( "http","www.educarex.es", 80, "/fp" ) );

      System.out.println( "Construye una direccion absoluta a partir de la \n"+
                          "direccion del Host y una URL relativa" );
      URL baseURL = new URL( "https://www.educarex.es");
      obj.mostrar( new URL( baseURL, "/fp/" ) );

    } 
    catch( MalformedURLException e ) {
      System.out.println( e );
    }
  }

  // Método para poder presentar en la pantalla partes de una dirección URL
  void mostrar( URL url ) {
	  
	//getProtocol(): Recupera el protocolo de conexión que se ha utilizado.  
    System.out.println("Protocolo:"+ url.getProtocol()+" " );
    //getHost(): Devuelve el nombre de la máquina
    System.out.println("Host:"+url.getHost()+" " );
    //getPort: Devuelve el número de puerto de la URL, -1 si no se indica.
    System.out.println("Puerto:"+ url.getPort()+" " );
    //getQuery(): Devuelve la cadena que se envía a una página para ser procesada
    //		      es lo que sigue al signo ? de una URL.
    System.out.println("Query:"+ url.getQuery());
    //getPath(): Devuelve una cadena con la ruta hacia el fichero desde el servidor
    // 			 y el nombre completo del fichero
    System.out.println("Path:"+ url.getPath()+" " );
    //getFile(): Devuelve lo mismo que getPath(), además de la concatenación del valor de
    //			 getQuery() si lo hubiese. Si no hay porción consulta, este método y getPath
    //			 devolverán los mismos resultados.
    System.out.println("Fichero/Directorio:"+ url.getFile()+" " );
    //getRef(): Devuelve la referencia de la URL
    System.out.println("Ref:"+ url.getRef() );
    //getUserInfo(): Devuelve la parte con los datos del usuario de la dirección URL o nulo
    //				 si no existe.
    System.out.println("Usuario:"+ url.getRef() ); 
 
    // Presentamos la dirección completa como una cadena
    System.out.println( url.toString() );
    System.out.println("_________________________________________________________________");
  }
}