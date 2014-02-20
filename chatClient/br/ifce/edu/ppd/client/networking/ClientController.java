package br.ifce.edu.ppd.client.networking;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ifce.edu.br.ppd.commons.Notifiable;
import br.ifce.edu.br.ppd.commons.util.MessageCode;

public class ClientController extends UnicastRemoteObject implements Notifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1695793710822536292L;

	protected ClientController() throws RemoteException {
		super();
	}

	@Override
	public String joinMessage(String name) throws RemoteException {
		return MessageCode.JOIN_MESSAGE.getMessage().replace("%username%", name);
	}

	@Override
	public String sendMessage(String name, String message) throws RemoteException {
		return MessageCode.SEND_MESSAGE.getMessage().replace("%username%", name)
													.replace("%message%", message);
	}

	@Override
	public String exitMessage(String name) throws RemoteException {
		return MessageCode.EXIT_MESSAGE.getMessage().replace("%username%", name);
	}

	@Override
	public void setUsername(String name) throws RemoteException {
		
	}

	@Override
	public String getUsername(String name) throws RemoteException {
		return null;
	}

}
