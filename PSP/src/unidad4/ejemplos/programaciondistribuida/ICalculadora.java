package unidad4.ejemplos.programaciondistribuida;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote {

		public int sumar(int o1,int o2) throws RemoteException;
		public int restar(int o1,int o2) throws RemoteException;
		public int multiplicar(int o1,int o2) throws RemoteException;
		public int dividir(int o1,int o2) throws RemoteException;
}
