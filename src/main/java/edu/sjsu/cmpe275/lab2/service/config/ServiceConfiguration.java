package edu.sjsu.cmpe275.lab2.service.config;

import edu.sjsu.cmpe275.lab2.service.ProfileService;
import edu.sjsu.cmpe275.lab2.service.ProfileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yutao on 3/9/16.
 */
@Configuration
@ComponentScan("edu.sjsu.cmpe275.lab2.service")
public class ServiceConfiguration {
    @Bean
    public ProfileService profileService() {
        return new ProfileServiceImpl();
    }
}
