package br.ifce.edu.ppd.client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.User;
import br.ifce.edu.ppd.commons.util.Constants;

public class ClientImpl extends UnicastRemoteObject implements Client,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3406115214810552789L;
	private User user;
	private String roomNameConnected;
	private String historyMessage = "";
	
	protected ClientImpl(User user) throws RemoteException {
		super();
		this.user = user;
		this.roomNameConnected = Constants.ROOM_DEFAULT;
	}

	public ClientImpl() throws RemoteException{
		super();
		user = new User();
		this.roomNameConnected = Constants.ROOM_DEFAULT;
	}
	
	public String getUsername() {
		return user.toString();
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
	
	public String getHistoryMessage() {
		return historyMessage;
	}

	public void appendHistoryMessage(String message) {
		this.historyMessage += message + "\n";
	}
	
	public void clearHistoryMessage(){
		this.historyMessage = "";
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
	    return (user.getUsername().equals(client.getUser().getUsername()));
	}
	
	@Override
	public int hashCode(){
		return this.user.getUsername().hashCode() + this.user.getId().hashCode();
	}

	@Override
	public void receiveMessage(String message) throws RemoteException{
		appendHistoryMessage(message);
	}
}
