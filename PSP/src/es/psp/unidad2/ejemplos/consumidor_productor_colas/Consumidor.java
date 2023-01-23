package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{

private BlockingQueue<Mensaje> cola;
private String nombre;
    
    public Consumidor(BlockingQueue<Mensaje> q, String nombre){
    	this.nombre=nombre;
        this.cola=q;
    }

    @Override
    public void run() {
        try{
        	Mensaje msj;
            //Lee mensajes hasta que recibe el mensaje exit
            while((msj = cola.take()).getMsj() !="exit"){
            Thread.sleep(10);
            System.out.println("El hilo "+nombre+" consume "+msj.getMsj());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}