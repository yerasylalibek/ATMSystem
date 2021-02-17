package com.system.atm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.system.atm")
@PropertySource("application.properties")
public class SpringConfiguration {
}
