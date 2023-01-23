package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {

    private BlockingQueue<Mensaje> cola;
    
    public Productor(BlockingQueue<Mensaje> q){
        this.cola=q;
    }
    @Override
    public void run() {
        //produce mensajes
        for(int i=0; i<100; i++){
        	Mensaje msj = new Mensaje(""+i);
            try {
                Thread.sleep(i);
                cola.put(msj);
                System.out.println("Produce "+msj.getMsj());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //añade el último mensaje para indicar que ha terminado
        Mensaje msj = new Mensaje("exit");
        try {
            cola.put(msj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}