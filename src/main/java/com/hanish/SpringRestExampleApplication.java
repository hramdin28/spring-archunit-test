package com.hanish;

import com.hanish.model.ThemeParkRide;
import com.hanish.service.ThemeParkRideService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeParkRideService service) {
        return (args) -> {
            service.createRide(new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", 5, 3));
            service.createRide(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", 3, 2));
            service.createRide(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", 2, 4));
        };
    }
}
