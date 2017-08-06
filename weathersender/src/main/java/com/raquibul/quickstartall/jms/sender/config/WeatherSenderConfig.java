package com.raquibul.quickstartall.jms.sender.config;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.raquibul.quickstartall.jms.sender.model.Rain;
import com.raquibul.quickstartall.jms.sender.model.Temperature;

/**
 * All the bean definition goes here
 * 
 * @author raquibul.hasan
 *
 */
@Configuration
public class WeatherSenderConfig {
	private static final String TYPE_ID_PROPERTY_NAME = "weatherreport";
	private static final String TEMPERATURE_TYPE_ID = "temperature";
	private static final String RAIN_TYPE_ID = "rain";
	
	@Bean
	public JmsListenerContainerFactory<?> weatherSenderFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName(TYPE_ID_PROPERTY_NAME);
		
		Map<String, Class<?>> typeIdMappings = new HashMap<String,Class<?>>();
		typeIdMappings.put(TEMPERATURE_TYPE_ID, Temperature.class);
		typeIdMappings.put(RAIN_TYPE_ID, Rain.class);
		converter.setTypeIdMappings(typeIdMappings);
		
		return converter;
	}
}
