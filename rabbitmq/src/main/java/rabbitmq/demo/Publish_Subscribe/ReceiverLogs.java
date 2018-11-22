package rabbitmq.demo.Publish_Subscribe;

import com.rabbitmq.client.*;

import java.io.IOException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/22 10:24
 */
public class ReceiverLogs {
    private static final String EXCHANGE_NAME="logs";
    public static void main(String []args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        String queueName=channel.queueDeclare().getQueue();
        channel.queueBind(queueName,EXCHANGE_NAME,"");
        System.out.println("length="+args.length);
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg=new String(body,"UTF-8");
                System.out.println(" [x] Received '" + msg + "'");

            }
        };
        channel.basicConsume(queueName,false,consumer);
    }
}
