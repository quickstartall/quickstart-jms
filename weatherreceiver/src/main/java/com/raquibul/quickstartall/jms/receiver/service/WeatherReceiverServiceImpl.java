package com.raquibul.quickstartall.jms.receiver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.raquibul.quickstartall.jms.receiver.WeatherReceiverException;
import com.raquibul.quickstartall.jms.receiver.model.Rain;
import com.raquibul.quickstartall.jms.receiver.model.Temperature;
import com.raquibul.quickstartall.jms.receiver.util.WeatherReceiverUtil;

@Service
public class WeatherReceiverServiceImpl implements WeatherReceiverService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherReceiverServiceImpl.class);

	@Override
	public void printRain(Rain rain) throws WeatherReceiverException {
		LOGGER.info("printRain :: method invoked");
		WeatherReceiverUtil.printRain(rain);
		LOGGER.info("printRain :: done printing rains in service");
	}
	
	@Override
	public void printTemperature(Temperature temperature) throws WeatherReceiverException {
		LOGGER.info("printTemperature :: method invoked");
		WeatherReceiverUtil.printTemerature(temperature);
		LOGGER.info("printTemperature :: Done printint teperatures in service");
	}
}
