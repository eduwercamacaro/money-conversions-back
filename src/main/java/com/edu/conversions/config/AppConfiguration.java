package com.edu.conversions.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.edu.conversions"})
@Configuration
@EnableConfigurationProperties
public class AppConfiguration {
}
