package br.ifce.edu.ppd.client;

import java.io.Serializable;
import java.rmi.RemoteException;

import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.User;
import br.ifce.edu.ppd.commons.util.Constants;

public class ClientImpl implements Client,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3406115214810552789L;
	private User user;
	private String roomNameConnected;
	
	protected ClientImpl(User user) throws RemoteException {
		super();
		this.user = user;
		this.roomNameConnected = Constants.ROOM_DEFAULT;
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

	public String getRoomNameConnected() {
		return roomNameConnected;
	}

	public void setRoomNameConnected(String roomNameConnected) {
		this.roomNameConnected = roomNameConnected;
	}
	
	@Override
	public void receiveMessage(String message, String username) throws RemoteException {
		ClientController.appendMessage(username + ": " + message);
	}
	
	@Override
	public String toString(){
		return this.user.toString();
	}
	
	@Override
	public boolean equals(Object o){
		if (o == this){
			return true;
		}
	    if (o == null){
	    	return false;
	    }
	    if (getClass() != o.getClass()){
	    	return false;
	    }
	    ClientImpl client = (ClientImpl) o;
	    return (user == client.getUser());
	}
	
	@Override
	public int hashCode(){
		return this.user.getUsername().hashCode() + this.user.getId().hashCode();
	}
}
