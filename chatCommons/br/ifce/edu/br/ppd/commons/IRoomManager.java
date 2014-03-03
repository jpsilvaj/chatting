package br.ifce.edu.br.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRoomManager extends Remote{
	public List<IRoom> getRoomList() throws RemoteException;
	public boolean createRoom(String name, User user) throws RemoteException;
	public boolean deleteRoom(String name, User user) throws RemoteException;
}
