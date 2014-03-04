package br.ifce.edu.ppd.client.view;

import java.awt.Container;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import br.ifce.edu.ppd.client.ClientImpl;
import br.ifce.edu.ppd.commons.view.ListClientsPanel;

public class ChatClient extends JFrame{	

	private static final long serialVersionUID = -7716037243160876089L;
	private ClientImpl client;
	private ChatMenuPanel chatMenuPanel = new ChatMenuPanel();
	private ChatPanel chatPanel = new ChatPanel();
	private ListClientsPanel clientsPanel = new ListClientsPanel();
		
	public ChatClient(){
		super("Chat client - RMI");
		this.setSize(1080,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setNameClient();
		this.setTitle("Chat client - RMI: " + this.client.getUser());
		this.addPanels();
		this.pack();
	}
	
	private void addPanels(){
		Container c = getContentPane();
		c.setLayout(new MigLayout("insets 15 15 15 15"));
		c.add(chatMenuPanel,"dock north");
		c.add(clientsPanel,"dock east, gapright 15, gapbottom 20");
		c.add(chatPanel,"span");
	}
	
	private void setNameClient(){
		String username = showInputDialog();	
		try {
			client = new ClientImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		client.getUser().setUsername(username);
		
	}
	
	private String showInputDialog(){
	    String inputValue = JOptionPane.showInputDialog("Insira o nome do cliente");
	    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")){
	        inputValue = showInputDialog();
	    }
	    return inputValue;
	}

	public ClientImpl getClient() {
		return client;
	}

	public void setClient(ClientImpl client) {
		this.client = client;
	}

	public ChatMenuPanel getChatMenuPanel() {
		return chatMenuPanel;
	}

	public void setChatMenuPanel(ChatMenuPanel chatMenuPanel) {
		this.chatMenuPanel = chatMenuPanel;
	}

	public ChatPanel getChatPanel() {
		return chatPanel;
	}

	public void setChatPanel(ChatPanel chatPanel) {
		this.chatPanel = chatPanel;
	}

	public ListClientsPanel getClientsPanel() {
		return clientsPanel;
	}

	public void setClientsPanel(ListClientsPanel clientsPanel) {
		this.clientsPanel = clientsPanel;
	}

}