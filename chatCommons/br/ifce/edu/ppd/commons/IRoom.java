package br.ifce.edu.ppd.commons;

import java.util.Set;

import br.ifce.edu.ppd.client.ClientImpl;

public interface IRoom{
	public User getOwner();
	public Set<Client> getClients();
	public void sendBroadcast(String message, String username);
	public boolean join(ClientImpl client);
}
