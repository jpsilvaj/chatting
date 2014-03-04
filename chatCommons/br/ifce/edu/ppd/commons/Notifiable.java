package br.ifce.edu.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notifiable extends Remote{
	public String joinMessage(String name) throws RemoteException;   
    public String sendMessage(String name, String message) throws RemoteException;   
    public String exitMessage(String name) throws RemoteException;
    public String setUsername(String name) throws RemoteException;
}
