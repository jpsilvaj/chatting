package br.sifce.edu.br.ppd.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.ifce.edu.br.ppd.commons.Notifiable;
import br.ifce.edu.br.ppd.commons.Reportable;
import br.ifce.edu.br.ppd.commons.Room;
import br.ifce.edu.br.ppd.commons.User;

public class ServerController extends UnicastRemoteObject implements Reportable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4035294655805694909L;
	
	private List<Room> rooms = new ArrayList<Room>();
	
	public ServerController() throws RemoteException{
		super();
		Room room = new Room();
		this.rooms.add(room);
	}
		
	public ServerController(List<Room> rooms) throws RemoteException{
		super();
		this.rooms = rooms;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public boolean join(Notifiable notify, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRoom(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean talk(String name, String message) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exit(Notifiable notify, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
