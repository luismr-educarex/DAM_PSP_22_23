package es.psp.unidad2.ejemplos.consumidor_productor_colas;

import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {

    private BlockingQueue<Mensaje> queue;
    
    public Productor(BlockingQueue<Mensaje> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
        	Mensaje msg = new Mensaje(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produce "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Mensaje msg = new Mensaje("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}