package com.boc.test.weather.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig extends WebMvcAutoConfiguration {

    private static final Logger logger =
            LoggerFactory.getLogger(ApplicationConfig.class.getCanonicalName());

    private static final String MATCHER_URL = "/weatherstations/**";
    private static final String SECURITY_PASSWORD = "a02fd31b";
    private static final String SECURITY_SALT = "7bcab69043692478";
    //private static final TextEncryptor encryptor = Encryptors.text(SECURITY_PASSWORD, SECURITY_SALT);
}

