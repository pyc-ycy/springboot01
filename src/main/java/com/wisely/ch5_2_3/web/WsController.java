//IntelliJ IDEA
//ch5_2_3
//WsController
//2020/2/5
// Author:御承扬
//E-mail:2923616405@qq.com

package com.wisely.ch5_2_3.web;

import com.wisely.ch5_2_3.domain.WiselyMessage;
import com.wisely.ch5_2_3.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.security.Principal;

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(@org.jetbrains.annotations.NotNull WiselyMessage message) throws Exception{
        Thread.sleep(300);
        return new WiselyResponse("Welcome,"+message.getName()+"!");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("pyc")){
            messagingTemplate.convertAndSendToUser("ycy",
                    "/queue/notifications",principal.getName()+"-send:"+msg);
        }else{
            messagingTemplate.convertAndSendToUser("pyc",
                    "/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }
}
