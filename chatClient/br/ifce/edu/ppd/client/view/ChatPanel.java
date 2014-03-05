package br.ifce.edu.ppd.client.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import br.ifce.edu.ppd.client.handler.ChatListener;

public class ChatPanel extends JPanel{
	private static final long serialVersionUID = 2355897564088181796L;
	JScrollPane historyMessageScrolledPane;
	JTextArea historyMessage;
	JPanel sendMessagePanel;
	JTextField textBox;
	
	public ChatPanel(){
		this.configureChat();
	}

	private void configureChat(){
		historyMessage = new JTextArea(35,90);
		historyMessage.setEditable(false);
		historyMessage.setLineWrap(true);
		historyMessage.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
		historyMessageScrolledPane = new JScrollPane(historyMessage);
		historyMessageScrolledPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		textBox = new JTextField(80);
		textBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		textBox.setActionCommand("send_message");
		textBox.addActionListener(new ChatListener());
		
		JButton send = new JButton("Send");
		send.setActionCommand("send_message");
		send.addActionListener(new ChatListener());
		
		sendMessagePanel = new JPanel();
		sendMessagePanel.setLayout(new FlowLayout());
		sendMessagePanel.add(textBox);
		sendMessagePanel.add(send);
	
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(historyMessageScrolledPane);
		this.add(sendMessagePanel);
		this.setVisible(true);
		
	}

	public void appendHistoryMessage(String message){
		historyMessage.append(message + "\n");
	}
}
