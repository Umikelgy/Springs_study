package rabbitmq.demo.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/22 15:05
 */
public class EmitLogTopic {
    private static final String EXCHANGE_NAME="topic_logs";
    public static void main(String[]args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String routingKey=getRouting(args);
        String msg=getMessage(args);

        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());

        channel.close();
        connection.close();
    }
    private static String getRouting(String[] strings){
        if (strings.length < 1)
            return "anonymous.info";
        return strings[0];
    }

    private static String getMessage(String[] strings){
        if (strings.length < 2)
            return "Hello World!";
        return joinStrings(strings, " ", 1);
    }

    private static String joinStrings(String[] strings, String delimiter, int startIndex) {
        int length = strings.length;
        if (length == 0 ) return "";
        if (length < startIndex ) return "";
        StringBuilder words = new StringBuilder(strings[startIndex]);
        for (int i = startIndex + 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
