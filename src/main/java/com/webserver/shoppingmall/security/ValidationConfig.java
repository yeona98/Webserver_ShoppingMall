package com.webserver.shoppingmall.security;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class ValidationConfig {

    @Bean
    public MessageSource messageSource() {
        Locale.setDefault(Locale.KOREA);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setBasenames("classpath:messages/message");

        return messageSource;
    }
}
