package br.ifce.edu.ppd.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import br.ifce.edu.ppd.client.view.ChatClient;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.commons.IRoomManager;
import br.ifce.edu.ppd.commons.util.Constants;

public class ClientController{
	
	static IRoomManager roomManager;
	static ChatClient chatClient;
	
	public static void main(String[] args) {
		try {
			chatClient = new ChatClient();
			roomManager = (IRoomManager) Naming.lookup("//localhost/ChatService");
			registryInRoom();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void registryInRoom(String roomNameToConnect){
		try {
			roomManager.addClientToRoom(roomNameToConnect, chatClient.getClient());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void registryInRoom(){
		try {
			Boolean teste = roomManager.addClientToRoom(Constants.ROOM_DEFAULT, chatClient.getClient());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void exitFromRoom(String roomName){
		try {
			roomManager.removeClientFromRoom(chatClient.getClient(), roomName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static List<IRoom> getRooms(){
		try {
			return roomManager.getRoomList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getRoomsName(){
		ArrayList<String> roomsName = new ArrayList<String>();
		for( IRoom room :  ClientController.getRooms()){
			roomsName.add(room.toString());
		}
		return roomsName;
	}

	public static void appendMessage(String message){
		chatClient.getChatPanel().appendHistoryMessage(message);
	}

	public static void createRoomInServer(String roomName){
		try {
			roomManager.createRoom(roomName, chatClient.getClient());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void removeRoomInServer(String roomName) {
		try {
			roomManager.deleteRoom(roomName, chatClient.getClient());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
