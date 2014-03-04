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
	static ChatServer chatServer;
	static RoomManagerImpl roomManager;
	static Boolean run = true;

	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			chatServer = new ChatServer();
			roomManager = new RoomManagerImpl();
			Naming.rebind("//localhost/ChatService", roomManager);
			TimerUpdateListOfClients timerUpdateClients = new TimerUpdateListOfClients();
			Timer t = new Timer();
			t.schedule(new TimerUpdateListOfClients(), 0, 1*1000);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void updateLogs(){
		//chatServer.getChatLogPanel()
		//TODO: Implement the routine to logging
	}
	
}
