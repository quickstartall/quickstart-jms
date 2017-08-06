package com.raquibul.quickstartall.jms.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.raquibul.quickstartall.jms.sender.config.WeatherSenderConfig;

@SpringBootApplication
@EnableScheduling
@Import(WeatherSenderConfig.class)
public class WeatherSenderApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeatherSenderApplication.class);
    }
}
