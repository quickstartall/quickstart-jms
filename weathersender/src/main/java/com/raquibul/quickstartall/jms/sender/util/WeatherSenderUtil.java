package com.raquibul.quickstartall.jms.sender.util;

import java.util.HashMap;
import java.util.Map;

import com.raquibul.quickstartall.jms.sender.model.Rain;
import com.raquibul.quickstartall.jms.sender.model.Temperature;

public class WeatherSenderUtil {

	private WeatherSenderUtil(){
		//blank intenstional
	}
	
	public static Rain getRain() {
		Rain rain = new Rain();
		rain.setMaxRain(1.2f);
		rain.setAverageRain(0.9f);
		
		Map<String, Float> placesRain = new HashMap<String, Float>();
		placesRain.put(generatePlace(), 1.4f);
		placesRain.put(generatePlace(), 0.4f);
		rain.setRains(placesRain);
		
		return rain;
	}
	
	public static Temperature getTemperature() {
		Temperature temperature = new Temperature();
		temperature.setAverageTemperature(23.5f);
		temperature.setMaxTemperature(40f);
		
		
		Map<String, Float> placesTemperature = new HashMap<String, Float>();
		placesTemperature.put(generatePlace(), 20f);
		placesTemperature.put(generatePlace(), 35.5f);
		temperature.setTemperatures(placesTemperature);
		
		return temperature;
	}
	
	
	private static String generatePlace() {
		return "randomPlace" + Math.random();
	}
}
