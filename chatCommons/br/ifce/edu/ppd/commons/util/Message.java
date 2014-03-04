package br.ifce.edu.ppd.commons.util;

import br.ifce.edu.ppd.commons.Notifiable;

public class Message implements Notifiable{
	
	@Override
	public String joinMessage(String name){
		return MessageCode.JOIN_MESSAGE.getMessage().replace("%username%", name);
	}
	
	@Override
	public String sendMessage(String name, String message){
		return MessageCode.SEND_MESSAGE.getMessage().replace("%username%", name)
													.replace("%message%", message);
	}
	
	@Override
	public String exitMessage(String name){
		return MessageCode.EXIT_MESSAGE.getMessage().replace("%username%", name);
	}
	
	@Override
	public String setUsername(String name){
		return MessageCode.SET_USERNAME.getMessage().replace("%username%", name);
	}
}