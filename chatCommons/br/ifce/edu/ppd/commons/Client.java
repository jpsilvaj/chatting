package br.ifce.edu.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote{
	public void receiveMessage(String message) throws RemoteException;
	public String getUsername() throws RemoteException;
}
