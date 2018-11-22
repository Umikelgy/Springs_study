package rabbitmq.demo.onePmoreC;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *@description:
 *一个producer，多个comsumer测试
 *@author 10068921(LgyTT)
 *@date 2018/11/22 9:47
 */
public class NewStask {
    private static final String QUEUE_NAME="One_Producer";
    public static void main(String []args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,true,false,false,null);//param:1,队列名称，2，是否持久化，3，是否独立队列，4，所有消费者长时间连接时是否删除队列，5，队列其他参数
        //分发信息
        for(int i=0;i<10;i++){
            String msg="RabbitMQ"+i;
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes());//param:1,交换机名称，2，队列映射的路由key,3，消息的其他属性 4，消息主体
            System.out.println("The Msg was send! "+i);
        }
        channel.close();
        connection.close();

    }
}
