package br.ifce.edu.br.ppd.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ifce.edu.br.ppd.commons.util.Constants;

public class Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4384764306217268192L;
	private String roomName;
	private List<User> users = new ArrayList<User>();
	
	public Room(String roomName){
		this.roomName = roomName;
	}
	
	public Room(){
		this.roomName = Constants.ROOM_DEFAULT;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public boolean addUserToRoom(User user){
		if (!users.contains(user)){
			users.add(user);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean removeUserFromRoom(User user){
		if (users.contains(user)){
			users.remove(user);
			return true;
		}
		else{
			return false;
		}
	}

}
