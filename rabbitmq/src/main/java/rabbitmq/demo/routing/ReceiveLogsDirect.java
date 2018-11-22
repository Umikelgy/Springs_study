package rabbitmq.demo.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/22 10:52
 */
public class ReceiveLogsDirect {
    private static final String EXCHANGE_NAME="direct_logs";
    public static void main(String[]args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection=factory.newConnection();
        Channel  channel=connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String queueName=channel.queueDeclare().getQueue();
/*
        if (args.length < 1){
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }*/
//        for (String severity:args)
        for(int i=0;i<6;i++)//打开管道与routingkey相同的队列相连接
            channel.queueBind(queueName,EXCHANGE_NAME,"info"+i);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String routingKey=envelope.getRoutingKey();
                String msg=new String(body,"UTF-8");
                System.out.println("[x] Received '"+routingKey+"':'"+msg+"'");
            }
        };
        channel.basicConsume(queueName,true,consumer);
    }
}
