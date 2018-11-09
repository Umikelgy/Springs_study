package rabbitmq.springboot.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/7 16:05
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1(){
        return new Queue("lgyTest1");
    }
    @Bean
    public Queue Queue2(){
        return  new Queue("lgyTest2");
    }
}
