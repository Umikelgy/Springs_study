package rabbitmq.demo.onePmoreC;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *@description:
 *一个producer，多个consumer
 *@author 10068921(LgyTT)
 *@date 2018/11/22 9:59
 */
public class Work {//consumer
    public static void main(String []args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection=factory.newConnection();
        final Channel channel=connection.createChannel();

        channel.queueDeclare("One_Producer",true,false,false,null);
        //公平调度，告诉RabbitMQ，再同一时刻，不要发送超过1条消息给一个工作者（worker），直到它已经处理了上一条消息并且作出了响应。
        channel.basicQos(1);

        final Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg=new String(body,"UTF-8");
                System.out.println("Received is '" +msg+"'");
                try {
                    doWork(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("basiAck Done");
                    //手动确认
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        channel.basicConsume("One_Producer",false,consumer);
    }
    private static void doWork(String msg) throws  InterruptedException{
        for(char ch:msg.toCharArray())
            if(ch=='.')Thread.sleep(1000);
    }
}
