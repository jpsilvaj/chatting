package br.ifce.edu.ppd.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import br.ifce.edu.ppd.server.view.ChatServer;

public class ServerController {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			ChatServer chatServer = new ChatServer();
			RoomManagerImpl roomManager = new RoomManagerImpl();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
