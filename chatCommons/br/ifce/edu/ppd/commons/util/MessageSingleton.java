package br.ifce.edu.ppd.commons.util;


public class MessageSingleton implements IMessage{
	
	private static MessageSingleton instance;
	
	private MessageSingleton() {
	}
	
	public static MessageSingleton getInstance(){
		if(instance == null){
			instance = new MessageSingleton();
		}
		return instance;
	}
	
	@Override
	public String joinMessage(String username, String roomname){
		return MessageCode.JOIN_MESSAGE.getMessage().replace("%username%", username)
													.replace("%roomname%", roomname);
	}
	
	@Override
	public String exitMessage(String username, String roomname){
		return MessageCode.EXIT_MESSAGE.getMessage().replace("%username%", username)
													.replace("%roomname%", roomname);
	}

	@Override
	public String createRoomMessage(String username, String roomname) {
		return MessageCode.CREATE_ROOM.getMessage().replace("%username%", username)
												   .replace("%roomname%", roomname);
	}

	@Override
	public String deleteRoomMessage(String username, String roomname) {
		return MessageCode.DELETE_ROOM.getMessage().replace("%username%", username)
				   								   .replace("%roomname%", roomname);
	}

	@Override
	public String sendMessage(String username, String message) {
		return MessageCode.SEND_MESSAGE.getMessage().replace("%username%", username)
				   									.replace("%message%", message);
	}
	
	
}