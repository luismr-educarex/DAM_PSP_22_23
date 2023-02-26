package unidad4.ejemplos.programaciondistribuida;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class App {

	
	public static void registrarCalculadora() {
		try {
			Registry registro = null;
			registro = LocateRegistry.createRegistry(5555);
			Calculadora calculadora = new Calculadora();
			registro.bind("Calculadora", (ICalculadora)UnicastRemoteObject.exportObject(calculadora, 0));
			System.out.println("Servidor arrancando...");
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}catch(AlreadyBoundException ex) {
			ex.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		 registrarCalculadora();
	}

}
