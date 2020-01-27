package com.task.exceptionhandler;

public class Error {

	private String userMessage;
	private String devMessage;
	
	
	public Error(String userMessage, String devMessage) {
		this.userMessage = userMessage;
		this.devMessage = devMessage;
	}
	

	
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getDevMessage() {
		return devMessage;
	}
	public void setDevMessage(String devMessage) {
		this.devMessage = devMessage;
	}

}
