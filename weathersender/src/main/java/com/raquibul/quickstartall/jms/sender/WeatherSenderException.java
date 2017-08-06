package com.raquibul.quickstartall.jms.sender;

@SuppressWarnings("serial")
public class WeatherSenderException extends Exception{
	public WeatherSenderException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public WeatherSenderException(String message) {
		super(message);
	}
	
	public WeatherSenderException(Throwable cause) {
		super(cause);
	}
}
