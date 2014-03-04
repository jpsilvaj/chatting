package br.ifce.edu.ppd.client;

import java.io.Serializable;
import java.rmi.RemoteException;

import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.User;

public class ClientImpl implements Client,Serializable{
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
	public void receiveMessage(String message, String username) throws RemoteException {
		ClientController.appendMessage(username + ": " + message);
	}
	
	public String toString(){
		return this.user.toString();
	}
}
