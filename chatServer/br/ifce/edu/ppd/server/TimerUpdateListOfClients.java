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
			for(IRoom room : ServerController.roomManager.getRoomList()){
				for(Client client : room.getClients()){
					newClients += ("Room:" + room + " Client:" + client.toString() + "\n");
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newClients.equals("")){
			newClients = "None";
		}
		ServerController.chatServer.getClientsPanel().getListOfClients().setText(newClients);
		
	}
	
}
