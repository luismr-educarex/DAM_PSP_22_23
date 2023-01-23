package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{

private BlockingQueue<Mensaje> queue;
private String nombre;
    
    public Consumidor(BlockingQueue<Mensaje> q, String nombre){
    	this.nombre=nombre;
        this.queue=q;
    }

    @Override
    public void run() {
        try{
        	Mensaje msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
            Thread.sleep(10);
            System.out.println("El hilo "+nombre+" cosume "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}