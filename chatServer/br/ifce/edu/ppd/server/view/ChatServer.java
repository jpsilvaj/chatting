package br.ifce.edu.ppd.server.view;

import java.awt.Container;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import br.ifce.edu.ppd.commons.view.ListClientsPanel;

public class ChatServer extends JFrame{
	private static final long serialVersionUID = -370081278553197224L;
	private ListClientsPanel clientsPanel = new ListClientsPanel();
	private ChatLogPanel chatLogPanel = new ChatLogPanel(); 
	
	public ChatServer(){
		super("Chat Server RMI");
		this.setSize(1080,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.addPanels();
		this.pack();
	}
	
	private void addPanels(){
		Container c = getContentPane();
		c.setLayout(new MigLayout("insets 15 15 15 15"));
		c.add(clientsPanel,"dock east, gapright 15, gapbottom 20");
		c.add(chatLogPanel,"span 10");
	}
	public ListClientsPanel getClientsPanel() {
		return clientsPanel;
	}

	public void setClientsPanel(ListClientsPanel clientsPanel) {
		this.clientsPanel = clientsPanel;
	}

	public ChatLogPanel getChatLogPanel() {
		return chatLogPanel;
	}

	public void setChatLogPanel(ChatLogPanel chatLogPanel) {
		this.chatLogPanel = chatLogPanel;
	}

}
