package br.ifce.edu.ppd.client.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.ifce.edu.ppd.commons.util.Constants;

public class ChatMenuPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3774041554169510911L;
	JMenuBar menuBar;

	public ChatMenuPanel(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT));;
		configureMenuBar();
	}
	
	private void configureMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Box.createHorizontalGlue());
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		ImageIcon exitIcon = new ImageIcon("exit.png");
		JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon);
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		JMenu room = new JMenu("Room");
		room.setMnemonic(KeyEvent.VK_R);
		
		ImageIcon roomIcon = new ImageIcon("room.png");
		
		JMenuItem createRoomMenuItem = new JMenuItem("Create room", roomIcon);
		createRoomMenuItem.setMnemonic(KeyEvent.VK_C);
		createRoomMenuItem.setToolTipText("Create room");
		createRoomMenuItem.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,"Not yet implemented");
				//TODO: Create Room action
			}
		});
		
		JMenuItem deleteRoomMenuItem = new JMenuItem("Delete room", roomIcon);
		deleteRoomMenuItem.setMnemonic(KeyEvent.VK_D);
		deleteRoomMenuItem.setToolTipText("Delete room");
		deleteRoomMenuItem.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,"Not yet implemented");
				//TODO: Surrender action
			}
		});
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		ImageIcon aboutIcon = new ImageIcon("about.png");
		JMenuItem aboutMenuItem = new JMenuItem("About", aboutIcon);
		aboutMenuItem.setMnemonic(KeyEvent.VK_A);
		aboutMenuItem.setToolTipText("About application");
		aboutMenuItem.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,Constants.ABOUT);
			}
		});
		
		file.add(eMenuItem);
		room.add(createRoomMenuItem);
		room.add(deleteRoomMenuItem);
		help.add(aboutMenuItem);

		menuBar.add(file);
		menuBar.add(room);
		menuBar.add(help);
		
		this.add(menuBar);
		this.setVisible(true);
	}

}
