package rabbitmq.demo.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *@description:
 *按路线发送接收
 *@author 10068921(LgyTT)
 *@date 2018/11/22 10:41
 */
public class EmitLogDirect {
    private static final String EXCHANGE_NAME="direct_logs";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String severity=getSeverity(args);
        String message=getMessage(args);

        for(int i=0;i<6;i++){//绑定不同的routingkey和msg，
                message=message+i;
            channel.basicPublish(EXCHANGE_NAME, severity+i, null, message.getBytes());
        }

    System.out.println("[x] sent '" + severity + "':'" + message + "'");
        channel.close();
        connection.close();
    }

    private static String getMessage(String[] args) {
        if(args.length<2)
            return "Hello World!";
        return joinStrings(args," ",1);
    }

    private static String joinStrings(String[] args, String s, int i) {
        int length=args.length;
        if(length==0)return "";
        if(length<i) return "";
        StringBuilder words=new StringBuilder(args[i]);
        for(int j=i+1;j<length;j++){
            words.append(s).append(args[j]);
        }
        return words.toString();
    }

    private static String getSeverity(String[] args) {
        if(args.length<1)
            return "info";
             return args[0];
    }
}
