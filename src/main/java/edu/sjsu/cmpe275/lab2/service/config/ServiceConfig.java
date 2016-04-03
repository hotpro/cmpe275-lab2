package edu.sjsu.cmpe275.lab2.service.config;

import edu.sjsu.cmpe275.lab2.service.ProfileService;
import edu.sjsu.cmpe275.lab2.service.ProfileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 */
@Configuration
@ComponentScan("edu.sjsu.cmpe275.lab2.service")
public class ServiceConfig {
    @Bean
    public ProfileService profileService() {
        return new ProfileServiceImpl();
    }
}
