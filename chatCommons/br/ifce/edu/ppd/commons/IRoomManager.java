package br.ifce.edu.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRoomManager extends Remote{
	public List<IRoom> getRoomList() throws RemoteException;
	public IRoom getRoomByClient(Client client) throws RemoteException;
	public boolean createRoom(String name, User user) throws RemoteException;
	public boolean deleteRoom(String name, User user) throws RemoteException;
	public boolean addClientToRoom(Client client, String roomName) throws RemoteException;
	public boolean removeClientFromRoom(Client client,String roomName) throws RemoteException;
	public void sendMessageToRoom(String roomName, String message, User user);
}
