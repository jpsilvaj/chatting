package br.ifce.edu.ppd.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.commons.IRoomManager;
import br.ifce.edu.ppd.commons.util.Constants;
import br.ifce.edu.ppd.commons.util.MessageSingleton;


public class RoomManagerImpl extends UnicastRemoteObject implements Serializable,IRoomManager{

	private static final long serialVersionUID = -5730655186581204474L;
	private Map<String,IRoom> rooms = new HashMap<String,IRoom>();
	private static MessageSingleton messageSingleton = MessageSingleton.getInstance();
	
	protected RoomManagerImpl() throws RemoteException {
		super();
		if ( !rooms.containsKey(Constants.ROOM_DEFAULT))
			rooms.put(Constants.ROOM_DEFAULT, new RoomImpl());
	}
	
	@Override
	public List<IRoom> getRoomList() throws RemoteException {
		List<IRoom> roomList = new ArrayList<IRoom>();
		for(IRoom room : rooms.values()){
			roomList.add(room);
		}
		return roomList;
	}
	
	@Override
	public IRoom getRoomByClient(Client client){
		for (Entry<String, IRoom> entry : rooms.entrySet()) {
	    	if (entry.getValue().getClients().contains(client)) {
	            return entry.getValue();
	        }
	    }
	    return null;
	}
	
	@Override
	public Set<Client> getClientsConnectedByRoomName(String roomname){
		return rooms.get(roomname).getClients();
	}

	@Override
	public boolean createRoom(String roomName, Client owner) throws RemoteException {
		if(!rooms.containsKey(roomName)){
			RoomImpl room = new RoomImpl(roomName, owner); 
			rooms.put(roomName,room);
			return true;
			//TODO: Send message to room
		}
		else{
			return false;
		}
	}

	@Override
	public boolean deleteRoom(String roomName, Client client) throws RemoteException {
		if(rooms.containsKey(roomName)){
			if(roomName.equalsIgnoreCase(Constants.ROOM_DEFAULT)){
				return false;
				
			}
			else if(rooms.get(roomName).getOwner().toString().equals(client.toString())){
				//rooms.get(roomName).sendBroadcast(message, roomname);
				rooms.remove(roomName);
				return true;
				//TODO: Send message to room
			}
		}
		return false;	
	}
	
	@Override
	public boolean sendMessageToRoom(String roomName, String message, Client client){
		if(rooms.get(roomName) != null && rooms.get(roomName).getClients().contains(client)){
			rooms.get(roomName).sendBroadcast(message, client.toString());
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean addClientToRoom(String roomName, Client client){
		if (!rooms.get(roomName).getClients().contains(client)){
			rooms.get(roomName).getClients().add(client);
			return true;
			//TODO: Send message to room
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean removeClientFromRoom(String roomName, Client client){
		if (rooms.get(roomName).getClients().contains(client)){
			rooms.get(roomName).getClients().remove(client);
			//TODO: Send message to room
			return true;
		}
		else{
			return false;
		}
	}
}