package br.ifce.edu.br.ppd.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import br.ifce.edu.br.ppd.commons.IRoom;
import br.ifce.edu.br.ppd.commons.Client;
import br.ifce.edu.br.ppd.commons.IRoomManager;
import br.ifce.edu.br.ppd.commons.Notifiable;
import br.ifce.edu.br.ppd.commons.User;
import br.ifce.edu.br.ppd.commons.util.MessageCode;


public class RoomManagerImpl extends UnicastRemoteObject implements Serializable,IRoomManager,Notifiable{

	protected RoomManagerImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = -5730655186581204474L;
	private Map<String,IRoom> rooms = new HashMap<String,IRoom>();
	
	@Override
	public List<IRoom> getRoomList() throws RemoteException {
		List<IRoom> roomList = new ArrayList<IRoom>();
		for(IRoom room : rooms.values()){
			roomList.add(room);
		}
		return roomList;
	}
	
	public Set<Client> getClientsConnectedByRoomName(IRoom room){
		return rooms.get(room.toString()).getClientsConnected();
	}
	

	@Override
	public boolean createRoom(String name, User user) throws RemoteException {
		if(!rooms.containsValue(name)){
			RoomImpl room = new RoomImpl(name, user); 
			rooms.put(name,room);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean deleteRoom(String name, User user) throws RemoteException {
		
		if(rooms.containsKey(name)){
			rooms.remove(name);
			//TODO: Notify everyone from room
			return true;
		}
		else{
			return false;	
		}
	}
	
	public void sendBroadcast(String message,String username){
		for(IRoom room : rooms.values()){
			for( Client client: room.getClientsConnected()){
				try {
					client.receiveMessage(message,username);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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
	public String setUsername(String name) throws RemoteException {
		return MessageCode.SET_USERNAME.getMessage().replace("%username%", name);
	}
	
}
