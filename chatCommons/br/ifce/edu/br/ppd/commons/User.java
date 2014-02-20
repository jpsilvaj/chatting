package br.ifce.edu.br.ppd.commons;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6043890892632974449L;
	private String username;
	private Room room;
	
	public User(String username){
		this.username = username;
		this.room = new Room();
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
