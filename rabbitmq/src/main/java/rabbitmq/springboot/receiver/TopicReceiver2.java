package rabbitmq.springboot.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/7 17:07
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {
    @RabbitHandler
    public void process(String msg){
        System.out.println("TopicReceiver2:"+msg);
    }
}
