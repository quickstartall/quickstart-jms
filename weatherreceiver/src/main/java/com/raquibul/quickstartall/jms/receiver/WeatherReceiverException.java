package com.raquibul.quickstartall.jms.receiver;

@SuppressWarnings("serial")
public class WeatherReceiverException extends Exception{
	public WeatherReceiverException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public WeatherReceiverException(String message) {
		super(message);
	}
	
	public WeatherReceiverException(Throwable cause) {
		super(cause);
	}
}
