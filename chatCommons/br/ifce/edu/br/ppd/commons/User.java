package br.ifce.edu.br.ppd.commons;

import java.util.UUID;

public class User{
	/**
	 * 
	 */
	private UUID id;
	private String username;
	
	public User(String username){
		this.username = username;
		this.id = UUID.randomUUID();
	}
	
	public User(){
		this.id = UUID.randomUUID();
	}

	public UUID getId(){
		return this.id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString(){
		return this.username;
	}
}
