package es.psp.unidad2.ejemplos.consumidor_productor_colas;

public class Mensaje {
    private String msg;
    
    public Mensaje(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

}
