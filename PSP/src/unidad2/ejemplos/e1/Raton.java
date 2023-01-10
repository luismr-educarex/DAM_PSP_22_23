package unidad2.ejemplos.e1;

public class Raton {
	
	private String nombre;
	private int tiempoAlimentacion;
	
	
	public Raton(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public void comer() {
		try {
			System.out.printf("El ratón %s ha comenzado a alimentarse%n",nombre);
			Thread.sleep(tiempoAlimentacion*1000);
			System.out.printf("El ratón %s ha terminado de alimentarse%n",nombre);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Raton pop = new Raton("Pop",4);
		Raton almendra = new Raton("Almendra",5);
		Raton cuky = new Raton("Cuky",4);
		Raton ciro = new Raton("Ciro",5);
		
		pop.comer();
		almendra.comer();
		cuky.comer();
		ciro.comer();
		
	}

}
