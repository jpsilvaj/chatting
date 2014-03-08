package br.ifce.edu.ppd.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ifce.edu.ppd.client.view.ChatClient;
import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.commons.IRoomManager;
import br.ifce.edu.ppd.commons.util.Constants;
import br.ifce.edu.ppd.client.TimerUpdateListOfClients;

public class ClientController{
	
	private static IRoomManager roomManager;
	private static ChatClient chatClient;
	private static Set<Client> clients;
	private static boolean hasConnected = false;
	private static Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	public static void main(String[] args) {
		try {
			chatClient = new ChatClient();
			Naming.rebind("//localhost/"+chatClient.getClient().toString(), chatClient.getClient());
			roomManager = (IRoomManager) Naming.lookup("//localhost/ChatService");
			Timer timerUpdateClients = new Timer();
			Timer timerUpdateChatMessage = new Timer();
			timerUpdateClients.schedule(new TimerUpdateListOfClients(), 0, 2*1000);
			timerUpdateChatMessage.schedule(new TimerUpdateChatMessage(),0, 2*1000);
			registryInRoom();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		} catch (NotBoundException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
		
	}
	
	public static void registryInRoom(String roomNameToConnect){
		try {
			if(hasConnected){
				roomManager.removeClientFromRoom(chatClient.getClient().getRoomNameConnected(),chatClient.getClient());
			}
			roomManager.addClientToRoom(roomNameToConnect, chatClient.getClient());
			chatClient.getClient().setRoomNameConnected(roomNameToConnect);
			hasConnected = true;
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
	}
	
	public static void registryInRoom(){
		try {
			if(hasConnected){
				roomManager.removeClientFromRoom(chatClient.getClient().getRoomNameConnected(),chatClient.getClient());
			}
			Boolean teste = roomManager.addClientToRoom(Constants.ROOM_DEFAULT, chatClient.getClient());
			if(teste){
				hasConnected = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Cannot connect in room");
				//TODO: Implement to dispatch exception
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
	}
	
	public static void exitFromRoom(){
		try {
			boolean teste = roomManager.removeClientFromRoom(chatClient.getClient().getRoomNameConnected(),chatClient.getClient());
			if(teste){
				hasConnected = false;
				chatClient.getClient().setRoomNameConnected(Constants.ROOM_DEFAULT);
				chatClient.getClient().clearHistoryMessage();
			}
			else{
				JOptionPane.showMessageDialog(null, "Cannot leave from room");
				//TODO: Implement to dispatch exception
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
	}

	public static void createRoomInServer(String roomName){
		try {
			boolean teste = roomManager.createRoom(roomName, chatClient.getClient());
			if(teste){
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Cannot create room in server");
				//TODO: Implement to dispatch exception
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
	}

	public static void removeRoomInServer(String roomName) {
		try {
			boolean teste = roomManager.deleteRoom(roomName, chatClient.getClient());
			if(teste){
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Cannot remove room from server");
				//TODO: Implement to dispatch exception
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
	}
	
	public static List<IRoom> getRooms(){
		try {
			return roomManager.getRoomList();
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR: ", e);
		}
		return null;
	}
	
	public static ArrayList<String> getRoomsName(){
		ArrayList<String> roomsName = new ArrayList<String>();
		for( IRoom room :  ClientController.getRooms()){
			roomsName.add(room.toString());
		}
		return roomsName;
	}
	
	public static void sendMessageToRoom(String message) {
		try {
			for(Client client:clients){
				client.receiveMessage(message);
				//roomManager.sendMessageToRoom(chatClient.getClient().getRoomNameConnected(),
					//					  message,
						//				  chatClient.getClient());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR:", e);
		}
	}
	
	public static Set<Client> getListOfClientsFromRoom() {
		try {
			String roomname = chatClient.getClient().getRoomNameConnected();
			return roomManager.getClientsConnectedByRoomName(roomname);					
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("ERROR:", e);
		}
		return null;
	}

	public static Set<Client> lookupClients( Set<Client> clients) {
		Set<Client> rmiClients = new HashSet<Client>();
		for(Client client: clients){
			try {
				Client rmiClient = (Client) Naming.lookup("//localhost/"+client.getUsername().toString());
				rmiClients.add(rmiClient);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rmiClients;
	}
	
	public static IRoomManager getRoomManager() {
		return roomManager;
	}

	public static ChatClient getChatClient() {
		return chatClient;
	}

	public static void setClients(Set<Client> clients) {
		ClientController.clients = clients;
	}
}
