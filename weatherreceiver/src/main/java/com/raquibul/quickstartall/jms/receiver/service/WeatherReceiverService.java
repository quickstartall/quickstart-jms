package com.raquibul.quickstartall.jms.receiver.service;

import com.raquibul.quickstartall.jms.receiver.WeatherReceiverException;
import com.raquibul.quickstartall.jms.receiver.model.Rain;
import com.raquibul.quickstartall.jms.receiver.model.Temperature;

public interface WeatherReceiverService {
	void printRain(Rain rain) throws WeatherReceiverException;
	void printTemperature(Temperature temperature) 	throws WeatherReceiverException;
}
