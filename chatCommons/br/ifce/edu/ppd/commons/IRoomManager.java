package br.ifce.edu.ppd.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

public interface IRoomManager extends Remote{
	public List<IRoom> getRoomList() throws RemoteException;
	public IRoom getRoomByClient(Client client) throws RemoteException;
	public Set<Client> getClientsConnectedByRoomName(String roomname) throws RemoteException;
	public boolean createRoom(String name, Client client) throws RemoteException;
	public boolean deleteRoom(String name, Client client) throws RemoteException;
	public boolean addClientToRoom(String roomName, Client client) throws RemoteException;
	public boolean removeClientFromRoom(String roomName, Client client) throws RemoteException;
	public boolean sendMessageToRoom(String roomName, String message) throws RemoteException;
}
