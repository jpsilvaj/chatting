package br.ifce.edu.ppd.server.Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ifce.edu.ppd.client.ClientController;
import br.ifce.edu.ppd.commons.util.Constants;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "exit"){
			System.exit(0);
		}
		else if(e.getActionCommand() == "create_room"){
			String roomName = showInputDialog();
			ClientController.createRoomInServer(roomName);
		}
		else if(e.getActionCommand() == "delete_room"){
			
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

	
	
}
