package br.ifce.edu.br.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notifiable extends Remote{
	public String joinMessage(String name) throws RemoteException;   
    public String sendMessage(String name, String message) throws RemoteException;   
    public String exitMessage(String name) throws RemoteException;
    public void setUsername(String name) throws RemoteException;
    public String getUsername(String name) throws RemoteException;
}
