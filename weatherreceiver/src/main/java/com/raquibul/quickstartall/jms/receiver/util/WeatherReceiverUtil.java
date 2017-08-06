package com.raquibul.quickstartall.jms.receiver.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raquibul.quickstartall.jms.receiver.model.Rain;
import com.raquibul.quickstartall.jms.receiver.model.Temperature;

public class WeatherReceiverUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherReceiverUtil.class);
	
	private WeatherReceiverUtil() {
		//Blank is intentional
	}
	
	public static void printRain(Rain rain) {
		if (rain != null)  {
			LOGGER.info("printRain :: average rain={}", rain.getAverageRain());
			LOGGER.info("printRain :: max rain={}", rain.getMaxRain());
			Map<String, Float>  rains = rain.getRains();
			if (rains != null) {
				for (String key : rains.keySet()) {
					LOGGER.info("printRain :: Place={} ,rain={}", key, rains.get(key));
				}
			}
		}
	}
	
	public static void printTemerature(Temperature temperature) {
		if (temperature != null)  {
			LOGGER.info("printTemperature :: averagetemperature={}", temperature.getAverageTemperature());
			LOGGER.info("printTemperature :: max temperature={}", temperature.getMaxTemperatureTillNow());
			Map<String, Float>  temperatures = temperature.getTemperatures();
			if (temperatures != null) {
				for (String key : temperatures.keySet()) {
					LOGGER.info("printTemperature :: Place={} ,temperature={}", key, temperatures.get(key));
				}
			}
		}
	}
	
}
