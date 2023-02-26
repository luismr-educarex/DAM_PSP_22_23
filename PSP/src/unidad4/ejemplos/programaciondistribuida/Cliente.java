package unidad4.ejemplos.programaciondistribuida;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

	private ICalculadora calculadora = null;
	
	public Cliente() {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost",5555);
			calculadora = (ICalculadora) registro.lookup("Calculadora");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		int resultado;
		try {
			resultado = cliente.calculadora.sumar(3, 20);
			System.out.println(resultado);
		}catch(RemoteException e) {
			e.printStackTrace();
		}

	}

}
