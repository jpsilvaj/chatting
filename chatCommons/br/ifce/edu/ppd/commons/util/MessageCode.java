package br.ifce.edu.ppd.commons.util;

public enum MessageCode {
	EXIT_MESSAGE("O jogador %username% saiu do chat"),
	JOIN_MESSAGE("O jogador %username% entrou no chat"),
	SEND_MESSAGE("%username%: %message%"),
	SET_USERNAME("%username%=%newusername%"),
	GET_USERNAME("%username%"),
	CREATE_ROOM("The %username% created the room %roomname%"),
	DELETE_ROOM("The %username% deleted the room %roomname%");
	
	private String label;
	
	private MessageCode(String label){
		this.label = label;
	}
	
	public String getMessage(){
		return label;
	}
}
