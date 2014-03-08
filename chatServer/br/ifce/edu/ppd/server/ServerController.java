package br.ifce.edu.ppd.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Timer;

import javax.swing.JTextArea;

import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.server.view.ChatServer;

public class ServerController{
	private static ChatServer chatServer;
	private static RoomManagerImpl roomManager;
	static Boolean run = true;

	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			setChatServer(new ChatServer());
			roomManager = new RoomManagerImpl();
			Naming.rebind("//localhost/ChatService", roomManager);
			TimerUpdateListOfClients timerUpdateClients = new TimerUpdateListOfClients();
			Timer t = new Timer();
			t.schedule(new TimerUpdateListOfClients(), 0, 2*1000);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateLogs(){
		//chatServer.getChatLogPanel()
		//TODO: Implement the routine to logging
	}

	public static ChatServer getChatServer() {
		return chatServer;
	}

	public static void setChatServer(ChatServer chatServer) {
		ServerController.chatServer = chatServer;
	}
	
	public static RoomManagerImpl getRoomManager() {
		return roomManager;
	}

	public static void setRoomManager(RoomManagerImpl roomManager) {
		ServerController.roomManager = roomManager;
	}
}
