//IntelliJ IDEA
//ch5_2_3
//AuthorSettings
//2020/2/3
// Author:御承扬
//E-mail:2923616405@qq.com

package com.wisely.ch5_2_3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {
    private String name;
    private String mail;
    private Long age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getAge() {
        return age;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}
