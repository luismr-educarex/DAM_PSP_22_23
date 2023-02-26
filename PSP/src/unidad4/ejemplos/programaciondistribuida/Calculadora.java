package unidad4.ejemplos.programaciondistribuida;

import java.rmi.RemoteException;

public class Calculadora implements ICalculadora{

	@Override
	public int sumar(int o1, int o2) throws RemoteException {
		return o1+o2;
	}

	@Override
	public int restar(int o1, int o2) throws RemoteException {
		return o1-o2;
	}

	@Override
	public int multiplicar(int o1, int o2) throws RemoteException {
		return o1*o2;
	}

	@Override
	public int dividir(int o1, int o2) throws RemoteException {
		return o1/o2;
	}
	

}
