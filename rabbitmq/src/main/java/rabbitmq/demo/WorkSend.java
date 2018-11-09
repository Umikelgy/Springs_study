package rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/8 15:20
 */
public class WorkSend {
    private final static String Queue_name="hellowork";
    public static void main(String []args) throws Exception {
        Connection connection=ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(Queue_name,false,false,false,null);

        for(int i=0;i<100;i++){
            String message=""+i;
            channel.basicPublish("",Queue_name,null,message.getBytes());
            System.out.println("[x]Sent'"+message+"'");
            Thread.sleep(i*10);
        }
        channel.close();
        connection.close();
    }
}
