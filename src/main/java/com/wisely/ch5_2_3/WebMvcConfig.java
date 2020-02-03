//IntelliJ IDEA
//ch5_2_3
//WebMvcConfig
//2020/2/3
// Author:御承扬
//E-mail:2923616405@qq.com

package com.wisely.ch5_2_3;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebMvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/xx").setViewName("/xx");
    }
}
