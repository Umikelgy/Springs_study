package rabbitmq.springboot.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/7 16:18
 */
@Component
@RabbitListener(queues = "lgyTest2")
public class Receiver1 {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("Test1 receiver1:"+msg);
    }
}
