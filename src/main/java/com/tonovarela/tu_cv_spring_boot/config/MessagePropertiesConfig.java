package com.tonovarela.tu_cv_spring_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:message.properties")

}
)
public class MessagePropertiesConfig {

}
