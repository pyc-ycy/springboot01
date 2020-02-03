package com.wisely.ch5_2_3;

import com.wisely.ch5_2_3.bean.Person;
import com.wisely.ch5_2_3.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Ch523Application {

//    @Value("${author.name}")
//    private String authorName;
//    @Value("${author.mail}")
//    private String authorMail;
//    @Autowired
//    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("aa",11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
//        return "author name is"+authorSettings.getName()+", age is:"+authorSettings.getAge()
//                +", mail is:"+authorSettings.getMail();
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
