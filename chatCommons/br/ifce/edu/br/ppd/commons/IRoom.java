package br.ifce.edu.br.ppd.commons;

import java.util.Set;

import br.ifce.edu.ppd.client.ClientImpl;

public interface IRoom{
	public User getOwner();
	public Set<Client> getClientsConnected();
	public void sendBroadcast(String message, String username);
	public boolean join(ClientImpl client);
	public boolean addUserToRoom(Client client);
	public boolean removeUserFromRoom(Client client);
}
