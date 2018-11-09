package rabbitmq.springboot.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/7 16:58
 */
@Configuration
public class RabbitMaTopicConfig {
    final static String message="topic.message";
    final static String messages="topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(RabbitMaTopicConfig.message);
    }
    @Bean
    public Queue queueMessages(){
        return new Queue(RabbitMaTopicConfig.messages);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
