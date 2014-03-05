package br.ifce.edu.ppd.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import br.ifce.edu.ppd.client.ClientImpl;
import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.commons.User;
import br.ifce.edu.ppd.commons.util.Constants;

public class RoomImpl implements Serializable, IRoom{

	private static final long serialVersionUID = -4384764306217268192L;
	private String roomName;
	private Client owner;
	private Set<Client> clients = new HashSet<Client>();
	
	public RoomImpl(String roomName, Client client){
		this.roomName = roomName;
		this.owner = client;
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
	
	@Override
	public void sendBroadcast(String message, String username) {
		try {
			for( Client client : this.getClients()){
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
	public Client getOwner() {
		return this.owner;
	}

	@Override
	public Set<Client> getClients() {
		return this.clients;
	}
	
	public String toString(){
		return this.roomName;
	}
}
