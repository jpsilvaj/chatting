package br.ifce.edu.ppd.server;

import java.rmi.RemoteException;
import java.util.TimerTask;

import javax.swing.JTextArea;

import br.ifce.edu.ppd.commons.Client;
import br.ifce.edu.ppd.commons.IRoom;

public class TimerUpdateListOfClients extends TimerTask{

	@Override
	public void run() {
		String newClients = "";
		try {
			for(IRoom room : ServerController.getRoomManager().getRoomList()){
				for(Client client : room.getClients()){
					newClients += ("Room:" + room + " Client:" + client.getUsername().toString() + "\n");
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(newClients.equals("")){
			newClients = "None";
		}
		ServerController.getChatServer().getClientsPanel().getListOfClients().setText(newClients);
		
	}
	
}
