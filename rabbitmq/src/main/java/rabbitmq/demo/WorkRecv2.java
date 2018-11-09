package rabbitmq.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/8 15:41
 */
public class WorkRecv2 {
    private final static String Queue_name="hellowork";
    public static  void main(String []args) throws Exception {
        Connection connection=ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(Queue_name,false,false,false,null);
        boolean autoAck=false;
        WorkRecv2 recv2=new WorkRecv2();

//        recv2.getMessageByDefaultConsumer(channel,autoAck);
        recv2.getMessageByAtomicReference(channel);
        channel.close();
        connection.close();


    }
    private void getMessageByDefaultConsumer(Channel channel,boolean autoAck) throws IOException {//通过DefaultConsumer原型获取数据
        channel.basicConsume(Queue_name,autoAck,"myConsumer",new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String routingKey=envelope.getRoutingKey();//队列名
                String contentType=properties.getContentType();
                long deliveryTag=envelope.getDeliveryTag();
                // System.out.println(body);
                String string=new String(body,"UTF-8");//通过body转化string读取字符串
                System.out.println(contentType+"  "+string);
                channel.basicAck(deliveryTag,false);
            }
        });
    }
    private void getMessageByAtomicReference(Channel channel)throws Exception{//测试AtomicReference
        final CountDownLatch countDown=new CountDownLatch(6);
        final AtomicReference<byte[]> result=new AtomicReference<>();//是对对象进行原子操作，原子意味着多个线程试图改变同一个AtomicReference将不会使其处于不一致状态

        try {
            channel.basicConsume(Queue_name,true,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    result.set(body);
                    countDown.countDown();
                }
            });
            countDown.await(5, TimeUnit.SECONDS);
        }finally {

        }
        System.out.println(new String(result.get(),"UTF-8"));
    }

}
