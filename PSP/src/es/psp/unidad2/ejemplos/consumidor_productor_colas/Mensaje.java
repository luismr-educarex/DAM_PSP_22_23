package es.psp.unidad2.ejemplos.consumidor_productor_colas;

public class Mensaje {
    private String msj;
    
    public Mensaje(String str){
        this.msj=str;
    }

    public String getMsj() {
        return msj;
    }

}
