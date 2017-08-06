package com.raquibul.quickstartall.jms.sender.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.raquibul.quickstartall.jms.sender.WeatherSenderException;
import com.raquibul.quickstartall.jms.sender.util.WeatherSenderUtil;

@Service
public class WeatherSenderServiceImpl implements WeatherSenderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherSenderServiceImpl.class);
	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${out.queue.name.weather}")
	private String outWatherQueueName;
	
	@Override
	public void sendRain() throws WeatherSenderException{
		LOGGER.info("sendRain :: method invoked inside Service");
		jmsTemplate.convertAndSend(outWatherQueueName, WeatherSenderUtil.getRain());
		LOGGER.info("sendRain :: Done sending rain");
	}
	
	@Override
	public void sendTemperature() throws WeatherSenderException{
		LOGGER.info("sendTemperature :: method invoked inside Service");
		jmsTemplate.convertAndSend(outWatherQueueName, WeatherSenderUtil.getTemperature());
		LOGGER.info("sendTemperature :: Done sending temperature");
	}
	
}
