package br.ifce.edu.ppd.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import br.ifce.edu.ppd.client.ClientController;
import br.ifce.edu.ppd.commons.util.MessageSingleton;

public class ChatListener implements ActionListener, WindowListener{

	private MessageSingleton messageSingleton = MessageSingleton.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "send_message"){
			String message = ClientController.getChatClient().getChatPanel().getTextBox().getText();
			String username = ClientController.getChatClient().getClient().getUsername();
			ClientController.sendMessageToRoom(messageSingleton.sendMessage(username, message));
			ClientController.getChatClient().getChatPanel().getTextBox().setText("");
			//TODO: Implement send message
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Implement address of the URI RMI
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		windowClosed(e);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		try{
			ClientController.exitFromRoom();
		}catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			System.exit(0);
		}
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}