//IntelliJ IDEA
//ch5_2_3
//CustomServletContainer
//2020/2/4
// Author:御承扬
//E-mail:2923616405@qq.com

package com.wisely.ch5_2_3;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Component
public class CustomServletContainer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8888);    //设置启动端口
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));   //设置错误页面
        container.setSessionTimeout(10, TimeUnit.MINUTES);  //设置访问超时时间
    }
}
