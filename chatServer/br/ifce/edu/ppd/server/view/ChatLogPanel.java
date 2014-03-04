package br.ifce.edu.ppd.server.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ChatLogPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2355897564088181796L;
	JScrollPane logHistoryScrolledPane;
	JTextArea logHistory;
	
	public ChatLogPanel(){
		this.configureChatLog();
	}

	private void configureChatLog(){
		logHistory = new JTextArea(40,80);
		logHistory.setEditable(false);
		logHistory.setLineWrap(true);
		logHistory.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
		logHistoryScrolledPane = new JScrollPane(logHistory);
		logHistoryScrolledPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(logHistoryScrolledPane);
		this.setVisible(true);
		
	}

	public void appendHistoryLog(String log){
		logHistory.append(log + "\n");
	}
}
