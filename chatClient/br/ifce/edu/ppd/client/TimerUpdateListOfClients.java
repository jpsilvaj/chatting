package br.ifce.edu.ppd.client;

import java.rmi.RemoteException;
import java.util.Set;
import java.util.TimerTask;

import br.ifce.edu.ppd.commons.Client;

public class TimerUpdateListOfClients extends TimerTask{
	
	@Override
	public void run() {
		String newClients = "";
		Set<Client> clients = ClientController.getListOfClientsFromRoom(); 
		for(Client client : clients){
			try {
				newClients += (" Client:" + client.getUsername().toString() + "\n");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		if(newClients.equals("")){
			newClients = "None";
		}
		ClientController.getChatClient().getClientsPanel().getListOfClients().setText(newClients);
		Set<Client> rmiClients = ClientController.lookupClients(clients);
		ClientController.setClients(rmiClients);
	}
}
