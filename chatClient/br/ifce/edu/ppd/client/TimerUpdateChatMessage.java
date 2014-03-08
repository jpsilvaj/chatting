package br.ifce.edu.ppd.client;

import java.util.TimerTask;

public class TimerUpdateChatMessage extends TimerTask{
	
	@Override
	public void run() {
		String historyMessage = ClientController.getChatClient().getClient().getHistoryMessage();
		ClientController.getChatClient().getChatPanel().getHistoryMessage().setText(historyMessage);
	}
}
