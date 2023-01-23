package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProductorConsumidorServicio {

    public static void main(String[] args) {
        //Crearmos una BlockingQueue de tamaño 10 mensajes
        BlockingQueue<Mensaje> queue = new ArrayBlockingQueue<>(10);
        Productor productor = new Productor(queue);
        Consumidor consumidor = new Consumidor(queue,"consumidor1");
        //empieza el productor a producir mensajes en la cola
        new Thread(productor).start();
        //empieza el consumidor a consumir mensajes de la cola
        new Thread(consumidor).start();
       
        
        System.out.println("Productor y consumidores han empezado a ejecutarse");
    }

}