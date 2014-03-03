package br.ifce.edu.ppd.client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ifce.edu.br.ppd.commons.Client;
import br.ifce.edu.br.ppd.commons.IRoom;
import br.ifce.edu.br.ppd.commons.User;
import br.sifce.edu.br.ppd.server.RoomImpl;

public class ClientImpl extends UnicastRemoteObject implements Client,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3406115214810552789L;
	private User user;
	
	protected ClientImpl(User user) throws RemoteException {
		super();
		this.user = user;
	}

	public ClientImpl() throws RemoteException{
		super();
		user = new User();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String receiveMessage(String message, String username) throws RemoteException {
		return username + ": " + message;
	}

	@Override
	public void sendMessage(String message, IRoom room) throws RemoteException {
		room.sendBroadcast(message, this.user.toString());
	}

	@Override
	public boolean join(IRoom room) throws RemoteException {
		return room.addUserToRoom(this);
	}

	@Override
	public boolean exit(IRoom room) throws RemoteException {
		return room.removeUserFromRoom(this);
	}
}
