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
import br.ifce.edu.ppd.commons.User;
import br.ifce.edu.ppd.commons.util.Constants;

public class RoomManagerImpl extends UnicastRemoteObject implements Serializable,IRoomManager{

	private static final long serialVersionUID = -5730655186581204474L;
	private Map<String,IRoom> rooms = new HashMap<String,IRoom>();
	
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
	
	public Set<Client> getClientsConnectedByRoomName(IRoom room){
		return rooms.get(room.toString()).getClients();
	}
	

	@Override
	public boolean createRoom(String roomName, User owner) throws RemoteException {
		if(!rooms.containsKey(roomName)){
			RoomImpl room = new RoomImpl(roomName, owner); 
			rooms.put(roomName,room);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean deleteRoom(String roomName, User user) throws RemoteException {
		
		if(rooms.containsKey(roomName)){
			rooms.remove(roomName);
			//TODO: Notify everyone from room
			return true;
		}
		else{
			return false;	
		}
	}
	
	@Override
	public void sendMessageToRoom(String roomName, String message, User user){
		rooms.get(roomName).sendBroadcast(message, user.toString());
	}
	
	@Override
	public boolean addClientToRoom(Client client, String roomName){
		if (!rooms.get(roomName).getClients().contains(client)){
			rooms.get(roomName).getClients().add(client);
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean removeClientFromRoom(Client client, String roomName){
		if (rooms.get(roomName).getClients().contains(client)){
			rooms.get(roomName).getClients().remove(client);
			return true;
		}
		else{
			return false;
		}
	}
}
