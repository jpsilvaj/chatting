package br.ifce.edu.ppd.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import br.ifce.edu.ppd.client.view.ChatClient;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.commons.IRoomManager;

public class ClientController{
	
	static IRoomManager roomManager;
	static ChatClient chatClient;
	
	public static void main(String[] args) {
		try {
			chatClient = new ChatClient();
			roomManager = (IRoomManager) Naming.lookup("//localhost/ChatService");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void registryInRoom(String roomName) throws RemoteException{
		roomManager.addClientToRoom(chatClient.getClient(), roomName);
	}
	
	public static void exitFromRoom(String roomName) throws RemoteException{
		roomManager.removeClientFromRoom(chatClient.getClient(), roomName);
	}
	
	public static List<IRoom> getRooms() throws RemoteException{
		return roomManager.getRoomList();
	}

	public static void appendMessage(String message){
		chatClient.getChatPanel().appendHistoryMessage(message);
	}
}
