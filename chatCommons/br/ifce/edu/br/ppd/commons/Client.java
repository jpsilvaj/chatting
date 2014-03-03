package br.ifce.edu.br.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.ifce.edu.br.ppd.server.RoomImpl;

public interface Client extends Remote{
	public boolean join(IRoom room) throws RemoteException;
	public boolean exit(IRoom room) throws RemoteException;
	public String receiveMessage(String message, String username) throws RemoteException;
	public void sendMessage(String message, IRoom room) throws RemoteException;
}
