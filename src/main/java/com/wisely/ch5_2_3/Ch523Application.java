package com.wisely.ch5_2_3;

import com.wisely.ch5_2_3.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch523Application {

//    @Value("${author.name}")
//    private String authorName;
//    @Value("${author.mail}")
//    private String authorMail;
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    String index(){
        return "author name is"+authorSettings.getName()+", age is:"+authorSettings.getAge()
                +", mail is:"+authorSettings.getMail();
//        return "Spring Boot Demo Project, "+"author name is:"+authorName
//                +", author mail is:"+authorMail;
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
