package com.raquibul.quickstartall.jms.sender.service;

import com.raquibul.quickstartall.jms.sender.WeatherSenderException;


public interface WeatherSenderService {
	void sendRain() throws WeatherSenderException;
	void sendTemperature() throws WeatherSenderException;
}
