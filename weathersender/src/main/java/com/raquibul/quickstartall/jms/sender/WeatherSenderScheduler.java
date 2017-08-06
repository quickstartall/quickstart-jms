package com.raquibul.quickstartall.jms.sender;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.raquibul.quickstartall.jms.sender.service.WeatherSenderService;

@Component
public class WeatherSenderScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherSenderScheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    private WeatherSenderService weatherSenderService;
    
    @Scheduled(fixedRateString = "${weather.fetch.frequency.millis:10000}")
    public void sendWeather() {
    	System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "java.lang,java.util,com.raquibul.quickstartall.jms.sender");
    	try {
    		LOGGER.info("sendWeather :: About to send report from scheduler");
    		weatherSenderService.sendRain();
    		weatherSenderService.sendTemperature();
    	} catch(WeatherSenderException se) {
			LOGGER.info("sendWeather :: There was some error while sending rians and temperatures");
		}
        LOGGER.info("sendWeather ::The Weather Scheduler run at={}", dateFormat.format(new Date()));
    }
}
