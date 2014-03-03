package br.sifce.edu.br.ppd.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import br.ifce.edu.br.ppd.commons.Client;
import br.ifce.edu.br.ppd.commons.IRoom;
import br.ifce.edu.br.ppd.commons.User;
import br.ifce.edu.br.ppd.commons.util.Constants;
import br.ifce.edu.ppd.client.ClientImpl;

public class RoomImpl implements Serializable, IRoom{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4384764306217268192L;
	private String roomName;
	private User owner;
	private Set<Client> clients = new HashSet<Client>();
	
	public RoomImpl(String roomName, User owner){
		this.roomName = roomName;
		this.owner = owner;
	}
	
	public RoomImpl(){
		this.roomName = Constants.ROOM_DEFAULT;
		this.owner = null;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setUsers(HashSet<Client> clients) {
		this.clients = clients;
	}
	public boolean addUserToRoom(Client client){
		if (!clients.contains(client)){
			clients.add(client);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean removeUserFromRoom(Client client){
		if (clients.contains(client)){
			clients.remove(client);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void sendBroadcast(String message, String username) {
		try {
			for( Client client : this.getClientsConnected()){
				client.receiveMessage(message,username);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean join(ClientImpl client){
		if(!clients.contains(client)){
			clients.add(client);
			return true;
		}
		return false;
	}

	@Override
	public User getOwner() {
		return this.owner;
	}

	@Override
	public Set<Client> getClientsConnected() {
		return this.clients;
	}
	
	public String toString(){
		return this.roomName;
	}
}
