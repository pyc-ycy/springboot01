package com.wisely.ch5_2_3;

import com.wisely.ch5_2_3.bean.Person;
import com.wisely.ch5_2_3.config.AuthorSettings;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public String index(Model model) {
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
//        return "author name is"+authorSettings.getName()+", age is:"+authorSettings.getAge()
//                +", mail is:"+authorSettings.getMail();
//        return "Spring Boot Demo Project, "+"author name is:"+authorName
//                +", author mail is:"+authorMail;
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8081);
        connector.setSecure(false);
        connector.setRedirectPort(8080);
        return connector;
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


    //    @Component
//    public static class CustomServerContainer implements EmbeddedServletContainerCustomizer {
//        @Override
//        public void customize(ConfigurableEmbeddedServletContainer container) {
//            container.setPort(8888);    //设置启动端口
//            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));   //设置错误页面
//            container.setSessionTimeout(10, TimeUnit.MINUTES);  //设置访问超时时间
//        }
//    }
}
