package com.poly;


import com.poly.conf.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by Winnie on 14/04/2017.
 */
@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class App {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "DEV");
        SpringApplication.run(App.class, args);
    }
}
