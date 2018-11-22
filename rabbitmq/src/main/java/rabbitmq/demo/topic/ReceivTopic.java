package rabbitmq.demo.topic;

import com.rabbitmq.client.*;

import java.io.IOException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/22 15:11
 */
public class ReceivTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String queueName = channel.queueDeclare().getQueue();

          /*  if (argv.length < 1){
                System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
                System.exit(1);
            }*/

//            for(String bindingKey : argv)
                channel.queueBind(queueName, EXCHANGE_NAME, "anonymous.info");


            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            Consumer consumer=new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String routingKey=envelope.getRoutingKey();
                    String message=new String(body,"UTF-8");
                    System.out.println(" [x] Received '" + routingKey + "':'" + message + "'");
                }
            };
            channel.basicConsume(queueName, true, consumer);
        }
        catch  (Exception e) {
            e.printStackTrace();
        }
        channel.close();
        connection.close();
    }
}
