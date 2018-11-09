package rabbitmq.demo;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/8 15:23
 */
public class ConnectionUtil {
    public static Connection getConnection(){
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("guest" );
        factory.setPassword("guest");
        factory.setPort(5672);
        try {
            return factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
