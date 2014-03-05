package br.ifce.edu.ppd.commons;

import java.io.Serializable;
import java.util.UUID;

import br.ifce.edu.ppd.client.ClientImpl;

public class User implements Serializable{
	private static final long serialVersionUID = 3882541263489259793L;
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
	
	@Override
	public boolean equals(Object o){
		if (o == this){
			return true;
		}
	    if (o == null){
	    	return false;
	    }
	    if (getClass() != o.getClass()){
	    	return false;
	    }
	    User user = (User) o;
	    return (this.username == user.getUsername() && this.id == user.getId());
	}
	
	@Override
	public int hashCode(){
		return this.getUsername().hashCode() + this.getId().hashCode();
	}
}
