package br.ifce.edu.ppd.commons;

import java.util.Set;

import br.ifce.edu.ppd.client.ClientImpl;

public interface IRoom{
	public Client getOwner();
	public Set<Client> getClients();
	public boolean join(ClientImpl client);
	public void sendBroadcast(String message, String client);
}
