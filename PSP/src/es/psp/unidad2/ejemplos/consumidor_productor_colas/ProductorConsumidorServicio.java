package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProductorConsumidorServicio {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Mensaje> queue = new ArrayBlockingQueue<>(10);
        Productor producer = new Productor(queue);
        Consumidor consumer = new Consumidor(queue,"consumidor1");
        Consumidor consumer2 = new Consumidor(queue,"consumidor2");
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        //Thread hilo_consumidor = new Thread(consumer);
        //hilo_consumidor.setName("consumidor1");
        //Thread hilo_consumidor2 = new Thread(consumer2);
        //hilo_consumidor2.setName("consumidor2");
        new Thread(consumer).start();
        new Thread(consumer2).start();
        //hilo_consumidor.start();
        //hilo_consumidor2.start();
        System.out.println("Productor y consumidores han empezado a ejecutarse");
    }

}