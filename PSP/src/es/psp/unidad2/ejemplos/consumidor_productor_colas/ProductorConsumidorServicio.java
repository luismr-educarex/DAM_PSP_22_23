package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProductorConsumidorServicio {

    public static void main(String[] args) {
        //Crearmos una BlockingQueue de tamaño 10 mensajes
        BlockingQueue<Mensaje> queue = new ArrayBlockingQueue<>(10);
        Productor producer = new Productor(queue);
        Consumidor consumer = new Consumidor(queue,"consumidor1");
        Consumidor consumer2 = new Consumidor(queue,"consumidor2");
        //empieza el productor a producir mensajes en la cola
        new Thread(producer).start();
        //empieza el consumidor a consumir mensajes de la cola
        
        new Thread(consumer).start();
        new Thread(consumer2).start();
        
        System.out.println("Productor y consumidores han empezado a ejecutarse");
    }

}