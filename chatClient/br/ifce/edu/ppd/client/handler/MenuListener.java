package br.ifce.edu.ppd.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

import br.ifce.edu.ppd.client.ClientController;
import br.ifce.edu.ppd.commons.util.Constants;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "exit"){
			try{
				ClientController.exitFromRoom();
			}catch(Exception exception){
				exception.printStackTrace();
			}
			finally{
				System.exit(0);
			}
		}
		else if(e.getActionCommand() == "connect_room"){
			String roomNameToConnect = inputRoomSelected("Select room to connect");
			if (roomNameToConnect != null){
				ClientController.registryInRoom(roomNameToConnect);
			}else{
				JOptionPane.showMessageDialog(null, "Select a room to connect");	
			}
		}
		else if(e.getActionCommand() == "disconnect_room"){
			// Limit connection one room String roomNameToDisconnect = inputRoomSelected("Select room to disconnect");
			ClientController.exitFromRoom();
		}
		else if(e.getActionCommand() == "create_room"){
			String roomName = showInputDialog();
			ClientController.createRoomInServer(roomName);
		}
		else if(e.getActionCommand() == "delete_room"){
			String roomNameToDelete = inputRoomSelected("Select room to delete");
			if(roomNameToDelete == Constants.ROOM_DEFAULT){
				JOptionPane.showMessageDialog(null, "Cannot delete HOME room");	
			}
			ClientController.removeRoomInServer(roomNameToDelete);
		}
		else if(e.getActionCommand() == "about"){
			JOptionPane.showMessageDialog(null,Constants.ABOUT);
		}
		
	}
	
	private String showInputDialog(){
	    String inputValue = JOptionPane.showInputDialog("Insert the room name");
	    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")){
	        inputValue = showInputDialog();
	    }
	    return inputValue;
	}

	private String inputRoomSelected(String message){
		JList listRooms = new JList(ClientController.getRoomsName().toArray());
		JOptionPane.showMessageDialog(null, listRooms, message, JOptionPane.PLAIN_MESSAGE);
		String roomNameSelected = (String) listRooms.getSelectedValue();
		return roomNameSelected;
	}
}
