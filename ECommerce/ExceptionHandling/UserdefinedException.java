package com.sathish.ECommerce.ExceptionHandling;

public class UserdefinedException extends RuntimeException{


	private String Message;
	
	public UserdefinedException(String Message) {
		this.Message=Message;
	}
    
	@Override
	public String getMessage() {
		return Message;
	}
}
