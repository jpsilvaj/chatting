package br.ifce.edu.ppd.commons.util;

public interface IMessage {
	public String joinMessage(String username, String roomname);
	public String exitMessage(String username, String roomname);
	public String createRoomMessage(String username, String roomname);
	public String deleteRoomMessage(String username, String roomname);
	public String sendMessage(String username, String message);
}
