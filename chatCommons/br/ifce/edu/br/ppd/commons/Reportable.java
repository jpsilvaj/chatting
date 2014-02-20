package br.ifce.edu.br.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reportable extends Remote{
	public boolean join(Notifiable notify, String name) throws RemoteException;
	public boolean createRoom(String name) throws RemoteException;
	public boolean talk(String name, String message) throws RemoteException;
	public boolean exit(Notifiable notify, String name) throws RemoteException;
}
