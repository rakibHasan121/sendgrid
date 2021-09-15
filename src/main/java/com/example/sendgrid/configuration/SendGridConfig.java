package com.example.sendgrid.configuration;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rakib
 * Date: 2021-07-31
 * Projekt: sendgrid
 */
@Configuration
public class SendGridConfig {
    @Value("${sendgrid.key}")
    private String key;

    @Bean
    public SendGrid getSendgrid() {
        return new SendGrid(key);
    }

}
