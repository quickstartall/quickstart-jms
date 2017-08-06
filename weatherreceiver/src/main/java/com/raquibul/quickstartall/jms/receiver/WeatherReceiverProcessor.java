package com.raquibul.quickstartall.jms.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.raquibul.quickstartall.jms.receiver.model.Rain;
import com.raquibul.quickstartall.jms.receiver.model.Temperature;
import com.raquibul.quickstartall.jms.receiver.model.Weather;
import com.raquibul.quickstartall.jms.receiver.service.WeatherReceiverService;

@Component
public class WeatherReceiverProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherReceiverProcessor.class);
	
	@Autowired
	private WeatherReceiverService weatherService;
	
	@JmsListener(destination = "${in.queue.name.weather}", containerFactory = "weatherReceiverFactory")
	public void receiveMessage(Weather weather) {
		LOGGER.debug("receiveMessage::Received rain={}", weather);
		
		try {
			if (weather instanceof Rain) {
				weatherService.printRain((Rain)weather);	
			} else if (weather instanceof Temperature) {
				weatherService.printTemperature((Temperature)weather);
			} else {
				LOGGER.info("Invalid type");
			}
			
		} catch (WeatherReceiverException e) {
			LOGGER.error("There  was an error in the receiver", e);
		}
		LOGGER.info("Done Receiving message");
	}
	
	/*
	@JmsListener(destination = "${in.queue.name.weather}", containerFactory = "weatherReceiverFactory")
	public void receiveMessage(Rain rain) {
		LOGGER.debug("receiveMessage::Received rain={}", rain);
		
		try {
			weatherService.printRain(rain);
		} catch (WeatherReceiverException e) {
			LOGGER.error("There  was an error in the receiver", e);
		}
		LOGGER.info("Done Receiving Rain message");
	}
	
	@JmsListener(destination = "${in.queue.name.weather}", containerFactory = "weatherReceiverFactory")
	public void receiveMessage(Temperature temperature) {
		LOGGER.debug("receiveMessage::Received temperature={}", temperature);
		
		try {
			weatherService.printTemperature(temperature);
		} catch (WeatherReceiverException e) {
			LOGGER.error("There  was an error in the receiver", e);
		}
		LOGGER.info("Done Receiving Temperatue message");
	}*/

}
