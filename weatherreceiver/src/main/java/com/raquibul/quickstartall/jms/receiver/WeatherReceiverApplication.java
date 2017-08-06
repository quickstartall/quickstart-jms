package com.raquibul.quickstartall.jms.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.raquibul.quickstartall.jms.receiver.config.WeatherReceiverConfig;

@SpringBootApplication
@EnableScheduling
@Import(WeatherReceiverConfig.class)
public class WeatherReceiverApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeatherReceiverApplication.class);
    }
}
