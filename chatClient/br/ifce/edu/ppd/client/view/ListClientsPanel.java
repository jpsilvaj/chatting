package br.ifce.edu.ppd.client.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ListClientsPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6324864731693820673L;
	JTextArea listOfClients;
	
	public ListClientsPanel(){
		initListClientsPanel();
	}
	
	private void initListClientsPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
		JLabel listOfClientsLabel = new JLabel("Connected clients",JLabel.LEFT);
		listOfClientsLabel.setAlignmentX(LEFT_ALIGNMENT);
		listOfClientsLabel.setHorizontalAlignment(JLabel.LEFT);
//		listOfClientsLabel.setVerticalAlignment(SwingConstants.TOP);
		listOfClients = new JTextArea(12,12);
		listOfClients.setEditable(false);
		listOfClients.setLineWrap(true);
		listOfClients.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
		this.add(listOfClientsLabel);
		this.add(listOfClients);
		
	}

}
