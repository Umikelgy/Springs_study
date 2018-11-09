package rabbitmq.springboot.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/7 16:08
 */
@RestController
public class SendController {
    @Autowired
    private AmqpTemplate template;
    @RequestMapping(value = "/send")
    public String send(){
        String content="Date:"+new Date();
        template.convertAndSend("lgyTest1",content);
        return content;
    }
    @RequestMapping(value = "/muti2Mutisend")
    public String muti2Mutisend(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            template.convertAndSend("lgyTest1","第"+i+"次发送时间:"+time);
            template.convertAndSend("lgyTest2","第"+i+"次发送时间："+time);
            times.append(time+"<BR>");

        }
        return times.toString();
    }
    @RequestMapping(value = "/topicSend1")
    public String topicSend1(){
        String context="my top 1";
        System.out.println("发送者说:"+context);
        this.template.convertAndSend("exchange","topic.message",context);
        return context;
    }
    @RequestMapping(value = "/topicSend2")
    public String topicSend2(){
        String context="my topic 2";
        System.out.println("发送者:"+context);
        this.template.convertAndSend("exchange","topic.messages",context);
        return context;
    }
}
