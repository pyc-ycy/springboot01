package com.wisely.ch5_2_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch523Application {

    @RequestMapping("/")
    String index(){
        return "Spring Boot Demo Project";
    }

    public static void main(String[] args) {

//        SpringApplication.run(Ch523Application.class, args);
//        SpringApplication app = new SpringApplication(Ch523Application.class);
//        app.setShowBanner(false);
//        app.run(args);
        new SpringApplicationBuilder(Ch523Application.class)
                .showBanner(true)
                .run(args);
    }
}
