package br.ifce.edu.ppd.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import br.ifce.edu.ppd.client.ClientController;
import br.ifce.edu.ppd.commons.IRoom;
import br.ifce.edu.ppd.commons.util.Constants;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "exit"){
			System.exit(0);
		}
		else if(e.getActionCommand() == "connect_room"){
			String roomNameToConnect = inputRoomSelected("Select room to connect");
			ClientController.registryInRoom(roomNameToConnect);
		}
		else if(e.getActionCommand() == "disconnect_room"){
			String roomNameToDisconnect = inputRoomSelected("Select room to disconnect");
			ClientController.exitFromRoom(roomNameToDisconnect);
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
	    String inputValue = JOptionPane.showInputDialog("Insira o nome da sala: ");
	    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[\\s]*[1-9]*")){
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
