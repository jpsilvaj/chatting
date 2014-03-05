package br.ifce.edu.ppd.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ifce.edu.ppd.client.ClientController;

public class ChatListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "send_message"){
			//ClientController.sendMessageToRoom(message);
			//TODO: Implement send message
		}
		
	}

}
