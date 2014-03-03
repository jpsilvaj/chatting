package br.ifce.edu.ppd.client.view;

import java.awt.Container;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import br.ifce.edu.ppd.client.ClientImpl;

public class ChatClient extends JFrame{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7716037243160876089L;
	ChatMenuPanel chatMenuPanel = new ChatMenuPanel();
	ChatPanel chatPanel = new ChatPanel();
	ListClientsPanel clientsPanel = new ListClientsPanel();
	private ClientImpl client;
	
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
	
	private String showInputDialog()
	{
	    String inputValue = JOptionPane.showInputDialog("Insira o nome do cliente");

	    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*"))
	    {
	        inputValue = showInputDialog();
	    }

	    return inputValue;
	}

	private void registryClientInRoom(){
		try {
			Naming.lookup("");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}