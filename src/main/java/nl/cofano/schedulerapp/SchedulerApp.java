package nl.cofano.schedulerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
/**
 * Main class for starting the spring-boot application
 */
public class SchedulerApp {
	public static void main(String[] args) {
		SpringApplication.run(SchedulerApp.class, args);
	}
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
